package StringUse;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {
    public static void main(String[] args) {
        // 将一个字符串按照倒序的形式排序并输出
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串:");
        String inputstr = sc.next();

        // 将字符串变成数组的形式，然后才可以进行排序
        char[] cahrarray = inputstr.toCharArray();
        Arrays.sort(cahrarray);

        // 然后将排序号的字符串输出，使用forr可以直接生成倒序遍历数组的方法
        String resnew = new String();
        for (int i = cahrarray.length - 1; i >= 0; i--) {
            resnew += cahrarray[i];
        }
        System.out.println("倒叙排序好的字符串是:" + resnew);
    }
}
