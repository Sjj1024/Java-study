package JiHe;

import java.util.HashMap;
import java.util.Scanner;

public class CoutStr {
    public static void main(String[] args) {
        System.out.println("统计每个字符出现的次数");
        // 获取字符串，键盘输入。然后遍历每个字符，使用map存储，
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符:");
        String input = sc.next();
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> count_map = new HashMap<>();
        // 遍历字符数组，生成键
        for (char aChar : chars) {
//            System.out.println(aChar);
            count_map.put(aChar, 0);
        }
        // 再次遍历字符，统计出现的次数
        // 判断键是否存在map中
        for (char aChar : chars) {
            if (count_map.containsKey(aChar)) {
                int num = count_map.get(aChar) + 1;
                count_map.put(aChar, num);
            }
        }
        System.out.println("--------------------");
        System.out.println(count_map);
        for (Character character : count_map.keySet()) {
            System.out.println(character + ":" + count_map.get(character));
        }
    }
}
