package IOliu;

/*
* 主要有四种流对象:
* FileInputStream  文件输入流：从硬盘上读取二进制数据到内存中，也就是应用中
* FileOutputStream 文件输出流：将内存中的二进制数据输出到硬盘中，
*
* FileRead  ：字符流输入流对象，将硬盘中的字符流读取到内存中
* FileWrite ：字符输出流对象，将内存中的数据写入到硬盘中
*
* BufferedInputStream   ：输入缓冲流，读写数据的时候，可以加快输入输出
* BufferedOutputStream  ：输出缓冲流，写数据的时候，可以加快写入速度
*
* InputStreamReader     ：输入转换流，可以指定编码格式的输入流对象，方便实用
* OutputStreamReader    ：输出转换流，可以指定编码格式的输出流对象，方便实用
*
* */
public class BianMa {
    public static void main(String[] args) {
        System.out.println("编码解码-字符编码-就是一个编码规则");
        // utf-8是用的最多的编码，
        // FileRead默认只会读取系统默认编码格式的内容,所以可以使用转换流InputStreanmReader,可以指定指定的码表，OutputStreamReader也是一个转换流

    }
}
