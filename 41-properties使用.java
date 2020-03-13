package IOliu;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class ShuXIng {
    public static void main(String[] args) throws IOException {
        System.out.printf("属性类的使用，和HashMap有点类似，但是属性可以将数据写入和读取到磁盘上");
        // Properties类继承了HashTable，HashTable的键和值不允许为空，Propertis的键和值都是字符串类型
        Properties prp = new Properties();
        FileOutputStream fout = new FileOutputStream("properties.txt");
        // 向属性中设置键值对信息，类似HashMap的put方法
        prp.setProperty("name", "wangjialin");
        prp.setProperty("age", "18");
        prp.setProperty("height", "180");
        String name = prp.getProperty("name");
        System.out.println(name);
        prp.store(fout, "second");  // 将此属性中的键值对内容输出到磁盘中，第一个参数是输出流对象，第二个参数是备注信息，将会显示在第一行位置
        fout.close();

        // 使用load方法，可以将指定位置的属性文件中的内容加载进来
        System.out.println("-------------------------------------------");
        FileInputStream fis = new FileInputStream("properties.txt");
        Properties pro2 = new Properties();
        pro2.load(fis);
        // 使用keyset可以获取到键对象集合，然后使用get(键对象)获取相应的值
        Set<Object> objects = pro2.keySet();
        for (Object object : objects) {
            System.out.println("key:" + object + "value:" + pro2.get(object));
        }

        // 或者使用第二种方法：stringPropertyNames会返回键字符串集合
        System.out.println("--------------------------------------------");
        Set<String> strings = pro2.stringPropertyNames();
        for (String string : strings) {
            System.out.println("键:" + string + "值：" + pro2.getProperty(string));
        }
    }
}
