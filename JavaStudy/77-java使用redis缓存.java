package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoimpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceimpl implements CategoryService {
    // 创建一个共有的分类dao对象
    private CategoryDao categoryDao = new CategoryDaoimpl();

    @Override
    public List<Category> findAll() {
        // 因为分类数据不经常改变，为了减少数据库的压力，可以设置一个redis缓存
        Jedis jedis = JedisUtil.getJedis();
        // 从redis中获取一个category的值:用的是有序集合
        Set<String> category = jedis.zrange("category", 0, -1);
        if (category == null || category.size() == 0) {
            System.out.println("说明redis中没有缓存");
            List<Category> all = categoryDao.findAll();
            System.out.println("查询到结果了");
            // 将查询到的结果存储到redis中
            for (Category anAll : all) {
                // 将数据存储到redis的有序集合中
                jedis.zadd("category", anAll.getCid(), anAll.getCname());
            }
            return all;
        }else {
            System.out.println("从redis中开始查询。。。");
            List<Category> catlist = new ArrayList<Category>();
            for (String s : category) {
                Category one = new Category();
                one.setCname(s);
                catlist.add(one);
            }
            return catlist;
        }
    }
}
