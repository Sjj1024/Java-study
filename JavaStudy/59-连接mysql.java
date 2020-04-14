package com.boot.strap.test.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            //java10为数据库名
            String url = "jdbc:mysql://localhost:3306/tushu?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String userpwd = "xiaoshen";
            Connection conn = DriverManager.getConnection(url, username, userpwd);

            //创建Statement，执行sql
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println("名字" + rs.getString("name"));
                System.out.println("年齡" + rs.getInt("age"));
                System.out.println("性別" + rs.getString("score"));
            }

            //关闭连接
            rs.close();
            st.close();
            conn.close();
            //创建连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
