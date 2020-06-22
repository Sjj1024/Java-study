package it.com.heima.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String name;
    private Integer age;

    // 如果此类中包含有引用类型的其他类，则通过form序列化的时候，
    // 需要在表单中name属性改成accent.account,accent.password
    // 其中accent就是private Accent “accent”中的名;
    private Accent accent;

    // 如果属性中有list和map集合，则怎么通过form传递过来这些数据
    // 前端传递的时候，需要将form表单的name属性填写为：lists[0].account,lists[0].password
    private List<Accent> lists;
    // 传递map的话，需要将name属性填写为：maps["a"].account,maps["a"].password
    private Map<String, Accent> maps;

    public List<Accent> getLists() {
        return lists;
    }

    public void setLists(List<Accent> lists) {
        this.lists = lists;
    }

    public Map<String, Accent> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Accent> maps) {
        this.maps = maps;
    }

    public Accent getAccent() {
        return accent;
    }

    public void setAccent(Accent accent) {
        this.accent = accent;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", accent=" + accent +
                ", lists=" + lists +
                ", maps=" + maps +
                '}';
    }
}
