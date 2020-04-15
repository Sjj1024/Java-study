package com.boot.strap.test.JDBCDemo;

import com.boot.strap.test.Dao.Studentbean;
import com.boot.strap.test.Utils.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class SpringJDBC {
    public static void main(String[] args) {
        // updateName();
        // System.out.println("-------------------");
        // addDate();
        // System.out.println("----------------------");
        // delDate();
        System.out.println("---------------------");
        queryDate();
    }

    public static void updateName() {
        // 创建一个JdbcTemplate对象，需要传递一个数据库连接池对象，
        JdbcTemplate jdbct = new JdbcTemplate(DruidUtils.getDataSource());
        // 使用JdbcTemplate对象执行update方法可以操作增删改的操作，执行query方法可以操作查询方法
        String sql = "UPDATE student set name = ? WHERE id = 2";
        // 返回受影响的行数
        int res = jdbct.update(sql, "哈哈哈");
        System.out.println(res);
    }

    public static void addDate() {
        // 床架一个JDBCTemp对象
        JdbcTemplate jdbct = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "INSERT INTO student VALUES(?, ?, 55, 88.5, null, null)";
        int res = jdbct.update(sql, 6, "我是大爷");
        System.out.println(res);
    }

    public static void delDate() {
        // 删除数据，创建一个Jdbc对象
        JdbcTemplate jdbct = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "DELETE FROM student WHERE id=?";
        int res = jdbct.update(sql, 2);
        System.out.println(res);
    }

    public static void queryDate() {
        // 创建一个jdbc对象，查询结果
        JdbcTemplate jdbct = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "SELECT * FROM student WHERE id=?";
        // 将查询的结果集封装为一个Map集合，注意：只能是查询到一个结果时才能使用
        Map<String, Object> strMap = jdbct.queryForMap(sql, 3);
        System.out.println(strMap);
        System.out.println("-----------------------------------");
        sql = "SELECT * FROM student WHERE id=? or id=?";
        List<Map<String, Object>> maps = jdbct.queryForList(sql, 5, 6);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        System.out.println("----------------------------------");
        // 将结果封装成Bean对象，也就是数据库对象关系映射
        sql = "SELECT * FROM student";
        // 需要创建一个BeanPropertyRowMapper对象，并将数据库对象关系映射存放进去和字节码文件存放进去
        List<Studentbean> query = jdbct.query(sql, new BeanPropertyRowMapper<Studentbean>(Studentbean.class));
        for (Studentbean studentbean : query) {
            System.out.println(studentbean);
        }
    }
}
