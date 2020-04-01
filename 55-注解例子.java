package DemoTestZhuJie;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws Exception {
        System.out.println("我是一个简单的测试框架");

        // 创建一个Calcute类，获取字节码文件对象
        CalcuteClass cc = new CalcuteClass();
        Class<? extends CalcuteClass> aClass = cc.getClass();
        // 获取此类中被注解check标注的方法
        Method[] methods = aClass.getMethods();
        // 定义统计数字和写入log的流对象
        int num = 0;
        BufferedWriter buffw = new BufferedWriter(new FileWriter("error.txt"));
        for (Method method : methods) {
            System.out.println(method.getName());
            // 判断此方法是否是注解标注的类
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(cc);
                } catch (Exception e) {
                    num++;
                    buffw.write(method.getName() + "出现异常了");
                    buffw.newLine();
                    buffw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                    buffw.newLine();
                    buffw.write("异常的原因:" + e.getMessage());
                    buffw.newLine();
                    buffw.write("-------------------------------------");
                    buffw.newLine();
                }
            }
        }
        buffw.write("此次共出现了：" + num + "次异常");
        buffw.flush();
        buffw.close();
    }
}
