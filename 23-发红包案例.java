package HongBao;

import java.util.ArrayList;

public class StartHong {
    public static void main(String[] args) {
        System.out.println("开始群主和成员发红包程序");
        QunZhu wang = new QunZhu("国王", 1000);

        ChengYuan one = new ChengYuan("夏松",0);
        ChengYuan two = new ChengYuan("小李",0);
        ChengYuan three = new ChengYuan("小妹",0);

        ArrayList<Double> hblist = wang.send(200, 3);
        if (hblist.size() != 0){
            one.receive(hblist);
            two.receive(hblist);
            three.receive(hblist);
        }

        // 显示最后各个成员各自有多少元红包
        wang.showmoney();
        one.showmoney();
        two.showmoney();
        three.showmoney();
    }
}


群主和成员共有的父类：
package HongBao;

public class Person {
    String name = "";
    double mymoney = 0;

    public Person() {
    }

    public Person(String name, double mymoney) {
        this.name = name;
        this.mymoney = mymoney;
    }

    public void showmoney(){
        System.out.println(this.name + "最后有" + this.getMymoney() + "元");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMymoney() {
        return mymoney;
    }

    public void setMymoney(double mymoney) {
        this.mymoney = mymoney;
    }
}

// 群主类：
package HongBao;

import java.util.ArrayList;

public class QunZhu extends Person {
    public QunZhu() {
    }

    public QunZhu(String name, double mymoney) {
        super(name, mymoney);
    }

    // 定义发红包的方法，
    public ArrayList<Double> send(double jine, int geshu){
        System.out.println("开始发送红包");
        ArrayList<Double> hblist = new ArrayList<>();
        if(jine > this.getMymoney()){
            System.out.println("余额不足，无法发送");
            return hblist;
        }
        double everymoney = jine / geshu;
        double lossmoney = jine % geshu; // 取余数
        for (int i = 0; i < geshu; i++) {
            hblist.add(everymoney);
        }
        // 获取到群主余额，然后用余额减去红包后再设置回去
        this.setMymoney(this.getMymoney() - jine);
        System.out.println("群主发送了" + jine + "元红包!");
        return hblist;
    }
}


// 成员类
package HongBao;

import java.util.ArrayList;
import java.util.Random;

public class ChengYuan extends Person {
    public ChengYuan() {
    }

    public ChengYuan(String name, double mymoney) {
        super(name, mymoney);
    }

    public void receive(ArrayList<Double> hblist){
//        System.out.println("开始接收红包！");
        // 随机产生一个红包中的索引，获取其中的红包，然后删除红包数组中的红包
        int index = new Random().nextInt(hblist.size());
        double hongbao = hblist.remove(index);
        // 先获取余额，再将获取到的红包加上余额设置回去
        double mymoney = this.getMymoney();
        this.setMymoney(hongbao + mymoney);
        System.out.println(this.name + "抢到了" + hongbao + "元红包");
    }
}

