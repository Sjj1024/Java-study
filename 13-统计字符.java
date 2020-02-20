package StringUse;

import java.util.Scanner;

public class StrDemo2 {
    public static void main(String[] args) {
        // 键盘输入一串字符串，统计其中大写，小写，数字，其他字符出现的次数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String str1 = sc.next();
        System.out.println("输入的字符串是:".concat(str1));
        int countUpper = 0;
        int countLowper = 0;
        int countNumber = 0;
        int countOther = 0;
        // 将字符串转成字符列表，然后遍历字符列表，统计各个字符
        char[] strchar = str1.toCharArray();
        for (int i = 0; i < strchar.length; i++) {
            char temp = strchar[i];
            if('A' <= temp && temp <= 'Z'){
                countUpper++;
            }else if ('a' <= temp && temp <= 'z'){
                countLowper++;
            }else if ('0' <= temp && temp <= '9'){
                countNumber++;
            }else {
                countOther++;
            }
        }
        System.out.println("统计的大写字符个数是：" + countUpper);
        System.out.println("统计的小写字符个数是：" + countLowper);
        System.out.println("统计的数字字符个数是：" + countNumber);
        System.out.println("统计的其他字符个数是：" + countOther);
    }
}
