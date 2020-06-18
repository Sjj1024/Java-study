package cn.itcast.travel.util;

import redis.clients.jedis.Jedis;

public class jedistest {
    public static void main(String[] args) {
        // 操作redis数据库练习
        stringTest();
    }

    private static void stringTest() {
        // 创建一个jedis客户端，传入主机地址，就可以了
        Jedis jedis = new Jedis("localhost");
        // 操作字符串的方法
        String set = jedis.set("name", "王思聪");
        // 获取redis中的键值对信息
        String age = jedis.get("age");
        System.out.println(age);
    }
}
