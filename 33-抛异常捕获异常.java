package YiChang;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BuHuo {
    public static void main(String[] args) {
        System.out.println("捕获异常对象");
        // 捕获异常对象,
        String path = "c:\\1.txt";
        try {
            readfile(path);
        } catch (IOException e) {
            System.out.println("异常已经被捕获");
        }
        System.out.println("代码执行完继续执行后面的逻辑");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    private static void readfile(String path) throws IOException {
        System.out.println("检查文件是否存在");
        if (!"c:\\1.txt".equals(path)) {
            throw new FileNotFoundException("文件没有找到异常");
        }
        if (!path.endsWith("txt")) {
            throw new IOException("IO异常，文件不是以txt结尾的");
        }
    }
}
