package IOliu;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.printf("我是文件字节流，电脑上的所有文件都是字节，一切皆字节，当程序运行起来之后，是在内存中的，如果想和硬盘数据交互，就需要使用");
        // 写入数据的原理：java程序-》jvm-》os系统-》把文件写入数据
        // 创建一个FileOutStream对象的方法write，把数据写入到文件中：调用写入方法，.因为流会报异常，所以需要throw异常
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write(97);  // 写的时候，实际上是将97转成二进制的数据，写到文件中的，因为计算机智能存储二进制，记事本在打开文件的时候，都会打开编码表，将字节转成编码表
        fos.close();
        // 一次写多个字节的方法：write传入一个字节数组,就可以使用getBytes将字符创写入到文件中
        String html = "我是要被写入的数据";
        byte[] bytes = html.getBytes();
//        char[] chars = html.toCharArray();
//        for (byte aByte : bytes) {
//            System.out.printf(String.valueOf(aByte));
//        }
//
//        for (char aChar : chars) {
//            System.out.printf(String.valueOf(aChar));
//        }
        FileOutputStream fos2 = new FileOutputStream("dier.txt");
        fos2.write(bytes);
        fos2.close();

        // 数据的追加写和换行写:使用两个参数的构造方法
        FileOutputStream fos3 = new FileOutputStream("dier.txt", true); // true表示追加写，false表示不追加
        fos3.write("我爱你\n".getBytes());
        fos3.close();

        // 数据的追加写和换行写:使用两个参数的构造方法
        FileOutputStream fos4 = new FileOutputStream("dier.txt", true); // true表示追加写，false表示不追加
        fos4.write("\n我恨你".getBytes());
        fos4.close();
    }
}
