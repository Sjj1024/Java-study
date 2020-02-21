package StringUse;

import java.util.Arrays;

public class ArrayUse {
    public static void main(String[] args) {
        // Arrays工具类经常使用的两个方法：将数组转成字符串，对数组进行排序
        int[] intarray = {1, 5, 8, 9, 2, 4};
        // 使用数组转字符串的方法
        String str1 = Arrays.toString(intarray);
        System.out.println(str1);

        // 使用排序的方法:排序默认按照数值大小升序排列，也可以排字符串，默认按照字符串对应的ascall码排序
        Arrays.sort(intarray);
        System.out.println(Arrays.toString(intarray));
    }
}
