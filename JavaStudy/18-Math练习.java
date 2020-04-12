package MathUse;

public class Demo2 {
    public static void main(String[] args) {
        // 计算-10.8到正的5.9之间绝对值大于2的整数有几个
        int countnum = CountNum();
        System.out.println("统计出来的数字共有" + countnum);
    }

    public static int CountNum(){
        // 先获取-10.8到5.9之间的所有整数，然后统计绝对值大于2的
        int count = 0;
        int start = (int)Math.ceil(-10.8);
        int ends = (int)Math.floor(5.9);
        for (int i = start; i < ends; i++) {
            int absnum = Math.abs(i);
            if (absnum > 2){
                count++;
            }
        }
        return count;
    }
}
