package IOliu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFuZhi {
    public static void main(String[] args) throws IOException {
        System.out.printf("实现文件的赋值");
        // 将图片文件夹中的图片复制到指定目录中
        String picture = "C:\\Users\\swx829949\\Pictures\\boli.jpg";
        FileInputStream fis = new FileInputStream(picture);
        // 目标文件夹中文件路径
        String target = "D:\\tools\\boli.jpg";
        FileOutputStream fos = new FileOutputStream(target);

        // 使用一读一写的流程，完成文件的复制
        byte[] content = new byte[1024];
        int len = fis.read(content);
        while (len != -1) {
            // 将读到的文件写入到目标文件中
            fos.write(content);
            len = fis.read(content);
        }

        // 复制完后要释放资源，所以还要关闭流
        fis.close();
        fos.close();
    }
}
