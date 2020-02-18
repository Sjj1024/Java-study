package demo.list;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo4 {
    // 随机产生20个数字，放到大集合当中，然后筛选出其中的偶数，放到小集合当中
    public static void main(String[] args) {
        // 定义一个大集合存储20个随机数字
        ArrayList<Integer> listda = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listda.add(new Random().nextInt(100));
        }
        System.out.println("大集合已经生成: " + listda);
        // 调用筛选方法筛选出其中的偶数
        ArrayList<Integer> listres = checknum(listda);
        System.out.println("筛选出来的偶数集合是：" + listres);
    }

    public static ArrayList<Integer> checknum(ArrayList<Integer> list){
        ArrayList<Integer> listxiao = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0){
                listxiao.add(num);
            }
        }
        return listxiao;
    }
}
