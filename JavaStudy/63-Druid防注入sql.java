package com.boot.strap.test.JDBCDemo;

import com.boot.strap.test.Dao.Studentbean;
import com.boot.strap.test.Utils.DruidUtils;
import com.boot.strap.test.Utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class JDBCTest3 {
    public static void main(String[] args) {
        // 使用Druid数据库连接池技术连接数据库
        // 先获取一个数据库源对象，也就是数据库连接池对象
        // DataSource dataSource = DruidUtils.getDataSource();
        // 创建一个数据库对象关系映射集合，用于存储获取到得对象
        ArrayList<Studentbean> stuList = new ArrayList<>();
        // 再用数据库连接池获得一个连接对象
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DruidUtils.getConn();
            statement = connection.createStatement();
            String sql = "INSERT INTO student VALUES(5, ?, ?, ?, null, null)";
            // 插入数据的话需要使用sql的防注入方式，使用连接对象生成一个准备好的声明对象，然后使用该对象执行executeUpdate方法
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周芷若");
            preparedStatement.setInt(2, 46);
            preparedStatement.setDouble(3, 66.8);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(rs, statement, connection);
        }

    }
}
