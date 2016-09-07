package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class testJDBC {
    /**
     * 连接数据库，PreparedStatement操作，最后关闭结果集和链接。
     * @param args
     */
    public static void main(String[] args) {
        String driverClass = "com.mysql.jdbc.Driver";
        String ip= "192.168.1.111"; 	//"localhost";
        String url = "jdbc:mysql://"+ip+":3306/jsbq";
        String username = "root";
        String password = "";
        // 声明要放在try的外面。后面好关闭
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动类
            Class.forName(driverClass);
            long start = System.currentTimeMillis();
            // 建立连接
            conn = DriverManager.getConnection(url,username,password);
            long end = System.currentTimeMillis();
            System.out.println(conn +"建立连接耗时"+(end-start)+"ms");

            // 据说PreparedStatement可以防止sql注入,这是为什么
            String sql  = "select * from config_mission where count > ?";	// ?占位符
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 15);
            // ResultSet内部是个迭代器，连接中断结果就取不到
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t---------"+rs.getInt(2));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动类失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        } finally {
            try{
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try{
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
