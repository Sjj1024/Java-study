package DouDiZhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class DiZhhu {
    public static void main(String[] args) {
        System.out.println("斗地主案例");
        // 定义一个集合存储54张牌，因为整副牌随着发牌数量是会变化的
        ArrayList<String> all_num = new ArrayList<>();
        // 定义两个字符串数组，分别存储牌的颜色和序号，因为数组不可变，所以
        String[] colors = {"♥","♠","♦","♣"};
        String[] numbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        // 大小王直接存储到整副牌中，
        all_num.add("大王");
        all_num.add("小王");
        // 将两个数组组合成正副牌，存储到集合中
        for (String color : colors) {
            for (String number : numbers) {
                all_num.add(color + number);
            }
        }
        // 将正副牌打印出来
//        System.out.println(all_num);
        // 将集合中的元素随机排序
        Collections.shuffle(all_num);
//        System.out.println(all_num);
        // 开始发牌:定义四个集合，分别存储三个玩家和底牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        // 开始发牌：使用遍历正副牌的索引，判断该发给谁
        for (int i = 0; i < all_num.size(); i++) {
            // 判断索引是否大于51，是的话给玩家发牌，不是的话，给底牌
            if (i < 51){
                // 给玩家发牌:判断索引%3=0 给玩家1发牌，%3=1给玩家2发牌，%3=2给玩家3发牌
                if (i%3==0){
                    // 给玩家1发牌
                    play1.add(all_num.get(i));
                }else if (i%3==1){
                    // 给玩家2发牌
                    play2.add(all_num.get(i));
                }else if (i%3==2){
                    // 给玩家3发牌
                    play3.add(all_num.get(i));
                }
            }else {
                // 给底牌发牌
                dipai.add(all_num.get(i));
            }
        }
        // 打印出每个玩家的牌
        System.out.println("周润发:"+play1);
        System.out.println("王思聪:"+play2);
        System.out.println("王健林:"+play3);
        System.out.println("底牌:"+dipai);
    }
}
