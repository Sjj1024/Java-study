package StringUse;

public class StrDemo1 {
    public static void main(String[] args) {
        // 创建一个int数组，将int数组中的元素按照[word#word#word]格式拼接
        int[] intarray = {1, 4, 6};
        String resstr = geshi(intarray);
        System.out.println("格式化后的字符串是: ".concat(resstr));
    }

    public static String geshi(int[] array){
        String str1 = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1){
                str1 += array[i] + "]";
            }
            else{
                str1 += array[i] + "world";
            }
        }
        return str1;
    }
}
