package com.scores.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * jdbc工具类:使用驱动操作数据库
 * 为了执行某几句固定sql语句
 */

@Component
public class DBUtils {
    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    /**
     * 连接数据库
     * @return
     */
    public Connection getConnection(){
        Connection conn = null;
        try{
            //加载驱动
            Class.forName(DRIVER);
            //建立数据库连接
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Connection exception");
        }
        //返回连接对象
        return conn;
    }

    /**
     * 执行sql命令
     * @param connection
     * @param sql
     * @return
     * @throws Exception
     */
    public int executeSql(Connection connection, String sql) throws Exception{
        PreparedStatement ps = null;
        int rs = 0;
        ps = connection.prepareStatement(sql);
        rs = ps.executeUpdate();
        close(ps,connection);
        return rs;
    }


    /**
     * 关闭数据库连接
     * @param con
     */
    public void close(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     * @param ps
     * @param con
     */
    public void close(PreparedStatement ps, Connection con){
        try{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param con
     */
    public void close(ResultSet rs, PreparedStatement ps, Connection con){
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
