package com.connect.db;

import com.connect.db.ConnectionPool.PooledConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 从数据库连接池中获取连接来进行数据库操作
 * Created by Administrator on 2016/8/4.
 */
public class NewDBConn {
    public static ResultSet excutequery(String sql) throws SQLException {
        ResultSet rs = null;
        PooledConnection con =  DBManager.getConnection();
        if(con!=null){
            con.getConnection().setAutoCommit(true);
            rs = con.executeQuery(sql);
            con.close();
        }
        return rs;
    }

    public static int excuteupdate(String sql) throws SQLException{
        int rs = 0;
        PooledConnection con =  DBManager.getConnection();
        if(con!=null){
            con.getConnection().setAutoCommit(true);
            rs = con.executeUpdate(sql);
            con.close();
        }
        return rs;
    }

    public static int excutemulti(List<String> sqlList) throws SQLException{
        int rs = 0;
        PooledConnection con =  DBManager.getConnection();

        if(con!=null){
            con.getConnection().setAutoCommit(false);
            for(int i=0;i<sqlList.size();i++){
                try {
                    String sql = sqlList.get(i);
                    int result = con.executeUpdate(sql);
                    if(result==0){
                        con.getConnection().rollback();
                        rs=0;
                        break;
                    }else{
                        rs+=result;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    con.getConnection().rollback();
                    rs=0;
                    break;

                }
            }
            if(rs!=0) con.getConnection().commit();
            con.close();
        }
        return rs;
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            String sql1 = "insert into test values('"+i+"')";
            String sql2 = "update test set id='" +(i+5)+ "' where id='"+i+"'";
            List<String> sqlList = new ArrayList<String>();
            sqlList.add(sql1);
            sqlList.add(sql2);
            int rs = 0;
            try {
                rs = NewDBConn.excutemulti(sqlList);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(rs+"中文");
        }

        String sql = "select distinct(id) from test";
        try {
            ResultSet st = NewDBConn.excutequery(sql);
            while(st.next()){
                String rs1 = st.getString(1);
                System.out.print(rs1+"++\t++");
                String subSql = "select distinct(id) from test where id = "+st.getString(1);
                ResultSet st2 = NewDBConn.excutequery(subSql);
                while (st2.next()){
                    System.out.print(st2.getString(1)+"\t");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
