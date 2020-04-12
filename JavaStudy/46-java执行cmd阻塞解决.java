参考链接:https://www.cnblogs.com/zhufu9426/p/7928570.html

package com.huawei.cbg.tool.util;
import java.io.IOException;

public class ServerRunCmd {
//        public static void main(String[] args) {
//        run_cmd("python D:\\Breeze\\pyinstall_exe.py");
//    }

    public static void run_cmd(String cmd) {
        Runtime rt = Runtime.getRuntime(); // 运行时系统获取
        try {
            // Process proc = rt.exec(cmd);// 执行命令
//            File filePath = new File("python D:\\Breeze\\pyinstall_exe.py");
            Process proc = rt.exec(cmd);
            StreamManage errorStream = new StreamManage(proc.getErrorStream(), "Error");
            StreamManage outputStream  = new StreamManage(proc.getInputStream(), "Output");
            errorStream.start();
            outputStream.start();
            try {
                // 等待线程结束
                errorStream.join();//注意这里
                outputStream.join();//注意这里
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
