package it.cast.showuser.dao.impl;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        // 1.创建jedis连接
        Jedis firstjedis = new Jedis("localhost", 6379);
        // 2.操作对应的方法
        // String res = firstjedis.set("myname", "wangjianlin");
        // System.out.println(res);

        // 获取数据
        // String myname = firstjedis.get("myname");
        // System.out.println(myname);

        // 删除数据
        // Long myname = firstjedis.del("myname");
        // System.out.println(myname);

        // 存储hash类型数据
        // Long hset = firstjedis.hset("myhash", "first", "first");
        // System.out.println(hset);

        // 获取hash类型数据
        // String hget = firstjedis.hget("myhash", "first");
        // System.out.println(hget);

        // 删除hash类型的值
        Long hdel = firstjedis.hdel("myhash", "first");
        System.out.println(hdel);


        // 3.关闭连接
        firstjedis.close();

    }
}
