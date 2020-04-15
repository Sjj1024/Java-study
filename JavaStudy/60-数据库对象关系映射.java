package com.boot.strap.test.Dao;

import java.util.Date;

public class Studentbean {
    // 因为数据库和类特别想，数据库表中，每一列都有一个名字和类别属性，那就可以和类中属性关联起来
    // 比如学生表中，有id，name，age，score，borthday， insert_time，那就可以单独创建一个类，来和它对应起来
    // 最后查出来每一个数据库中的元素，就可以和这个类绑定，创建一个类对象，从而很简单的使用
    private int id;
    private String name;
    private int age;
    private double score;
    private Date borthday;
    private Date insert_time;

    @Override
    public String toString() {
        return "Studentbean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", borthday=" + borthday +
                ", insert_time=" + insert_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    public Date getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }
}
