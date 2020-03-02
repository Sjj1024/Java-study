package TimerDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {
    public static void main(String[] args) {
        Date day = new Date();
        // 使用day对象输出字符串对象
        System.out.println(day.toString());
        // 使用格式化日期输出
        SimpleDateFormat fmormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat fmormat2 = new SimpleDateFormat("MM-dd");
        System.out.println("当前时间是:" + fmormat.format(day));
        System.out.println("当前时间是:" + fmormat2.format(day));

        //使用printf可以快速格式化日期
        System.out.println("------------------");
        System.out.printf("%tc\n", day); // %tc表示全部日期信息
        System.out.printf("%tF\n", day); // 年月日信息
        System.out.printf("%tT\n", day); // 时分秒信息

        // 使计算机延时睡眠多少秒，必须使用捕获异常来处理抛出的异常
        try {
            System.out.printf(new Date() + "\n");
            Thread.sleep(1000*3);
            System.out.printf(new Date() + "\n");
        }catch(Exception e){
            System.out.printf("获得一个异常");
        }

        // 如何测量时间间隔或消耗了多长时间
        System.out.printf("-----------------");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000*3);
        }catch (Exception e){
            System.out.printf("捕获到一个异常");
        }
        long ends = System.currentTimeMillis();
        long lose = ends - start;
        System.out.printf("消耗时间是；" + lose);
    }
}
