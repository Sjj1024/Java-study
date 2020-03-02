import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        Read();
    }

    public static void Write(){
        // 进行文件读取操作例子
        String file = "1.txt";
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("我是开始\n");
            fw.write("我是中间\n");
            fw.write("我是结尾\n");
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void Read(){
        String file = "1.txt";
        try {
            FileReader fr = new FileReader(file);
            int num = fr.read();
            while (num != -1){
                System.out.print((char)num);
                num = fr.read();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
