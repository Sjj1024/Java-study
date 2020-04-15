package com.boot.strap.test.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static String datebase;
    public static String username;
    public static String userpswd;
    public static String jdbcdriver;

    static {
        // 静态代码块给初始变量赋值，静态代码块随着类的加载而加载
        // 获取src下的jdbc配置
        URL resource = JDBCUtils.class.getClassLoader().getResource("jdbc.properties");
        String path = resource.getPath();
        System.out.println(path);
        Properties pro = new Properties();
        try {
            pro.load(new FileReader(path));
            datebase = pro.getProperty("datebase");
            username = pro.getProperty("username");
            userpswd = pro.getProperty("userpswd");
            jdbcdriver = pro.getProperty("jdbcdriver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        System.out.println("获取连接对象");
        Connection conn;
        // 加载驱动
        try {
            String url ="jdbc:mysql://localhost:3306/"+datebase+"?useSSL=false&serverTimezone=UTC";
            // Class.forName(jdbcdriver);
            conn = DriverManager.getConnection(url, username, userpswd);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection con, Statement sta, ResultSet res) {
        System.out.println("释放连接资源");
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void close(Connection con, Statement sta) {
        System.out.println("释放连接资源");
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
