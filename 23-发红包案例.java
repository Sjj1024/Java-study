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


