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
    }
}
