package com.jnshu.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String url = null;
    private static String driverClass = null;
    private static String userName = null;
    private static String passWord = null;

    static {
        //读取db.properties
        Properties properties = new Properties();
        //使用类路径的读取方式
        InputStream resourceAsStream = DBUtil.class.getResourceAsStream("/db.properties");
        //加载文件
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = properties.getProperty("url");
        driverClass = properties.getProperty("driverClass");
        userName = properties.getProperty("userName");
        passWord = properties.getProperty("passWord");

        //利用反射注册驱动信息
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,userName,passWord);
        return conn;
    }
}
