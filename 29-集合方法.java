package JiHeDemo;

import java.util.ArrayList;
import java.util.Collection;

public class JiHe {
    public static void main(String[] args) {
        System.out.println("集合的学习");
        // 数组的长度是固定的，集合长度可以变，数组只能存储同类数据，而集合可以存储任意类型数据
        // 集合有很多：vector，arraylist，linkedlist，treeset，hashset，linkedHsshet集合
        // 会使用集合存储数据，会遍历集合，掌握结合特性:list接口：有序集合，可重复数据，set接口：无需集合，不可重复，没有索引
        // 共性抽取：collection接口，定义所有的单列集合共性的方法，学习顶层接口，所有子类都可以使用
        System.out.println("学习collection接口常用功能");
        // add，clear，remove,contains,isempty,size
        Collection<String> str1 = new ArrayList<>();
        str1.add("你好");
        str1.add("世界");
        str1.add("张三");
        str1.add("李四");
        System.out.println(str1);
        System.out.println("---------------------");
        str1.remove("李四");
        System.out.println(str1);
        System.out.println("判断是否包含");
        System.out.println(str1.contains("张三"));
        System.out.println("判断是否为空");
        System.out.println(str1.isEmpty());
        System.out.println("清除所有元素");
        str1.clear();

        System.out.println("-------------------");
        str1.add("aaaaaa");
        str1.add("bbbbbbbbb");
        String res = str1.toString();
        System.out.println(res);
        System.out.println("-------------------");
        StringBuilder pinjie = new StringBuilder();
        for (String i:str1) {
            pinjie.append(i);
        }
        System.out.println(pinjie);
    }
}
