package IOliu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZiFuLIu {
    public static void main(String[] args) throws IOException {
        System.out.printf("使用字符流");
        // 使用字节流读取中文的，会出现乱码，所以出现了字符流Readr是最顶层的父类，是一个抽象类,以readr结尾的都是字符流，
        // 文件字符输入流FileReader,读取文件的方式是以一个一个字符读取的，所以不会出现乱
        FileReader fr = new FileReader("dier.txt");
        int len = fr.read();
        while (len != -1) {
            System.out.println((char)len);
            len = fr.read();
        }

        // 一次读取多个字符流，使用字符数组
        System.out.printf("---------------------------------");
        FileReader fr2 = new FileReader("dier.txt");
        char[] content = new char[1024];
        int len2 = fr2.read(content);
        while (len2 != -1) {
            System.out.printf(new String(content));
            len2 = fr2.read(content);
        }

        // 字符输出流，FileWriter，可以将字符串写入到硬盘中
        FileWriter fw = new FileWriter("zifu.txt");
        fw.write("我是被写入的内容啊");  //实际上有一个将字符转成字节的过程
        fw.flush(); // 当字符被转成字节后，其实字节数据还是保存在内存缓冲区中，并没有到文件中，所以此方法会将内存缓冲区的数据刷新到文件中
        fw.close(); // 当关闭字符流的时候，也会自动将缓冲区的内容，输出到文件中

        // flush和close的区别就在于flush之后，流对象fw还可以继续使用，但是close掉之后，就不能再使用了
        // 字符流的续写和换行:两个参数的构造方法，true表示续写开关
        FileWriter fw2 = new FileWriter("zifu.txt", true);
        fw2.write("我是新增加的内容");
        fw2.write("\n我是新增加的内容");
        fw2.close();
    }
}
