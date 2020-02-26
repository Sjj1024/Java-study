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
