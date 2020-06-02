package it.cast.showuser.dao.impl;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        // 1.创建jedis连接
        Jedis firstjedis = new Jedis("localhost", 6379);
        // 2.操作对应的方法
        String res = firstjedis.set("myname", "wangjianlin");
        System.out.println(res);
        // 3.关闭连接
        firstjedis.close();

    }
}
