package com.connect.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PreConn extends NewDBConn{
    private static final Logger logger = LogManager.getLogger(NewDBConn.class);

    public static ResultSet excutequery(String sql) throws SQLException {
        ResultSet rs = null;
        ConnectionPool.PooledConnection con =  DBManager.getConnection();
        if(con!=null){
            con.getConnection().setAutoCommit(true);
            rs = con.executeQuery(sql);
            con.close();
        }
        return rs;
    }

    public static int update(String sql, Object... obj) throws SQLException {

        int rs = 0;
        ConnectionPool.PooledConnection con =  DBManager.getConnection();
        if(con!=null){
            con.getConnection().setAutoCommit(true);
            rs = con.preUpdate(sql,obj);
            con.close();
        }
        return rs;
    }
    public static void main(String[] args) {
        logger.info("help");
    }
}
