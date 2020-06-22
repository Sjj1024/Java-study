package it.com.heima.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Integer age;

    // 如果此类中包含有引用类型的其他类，则通过form序列化的时候，
    // 需要在表单中name属性改成accent.account,accent.password
    private Accent accent;

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
                '}';
    }
}



第二个类；
package it.com.heima.bean;

import java.io.Serializable;

public class Accent implements Serializable {

    private String account;

    private String password;

    public Accent() {
    }

    public Accent(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Accent{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
