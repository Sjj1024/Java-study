package IOliu;

import ObjThree.Person;

import java.io.*;

public class XuLieHua {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        System.out.println("将对象以流的方式保存到硬盘中");
        // 对象的序列化了流：ObjectOutPutStream，这是写对象，将对象写入到硬盘中，需要传入一个字节输入流
        // 对象的反序列化流：ObjectInputStream,这是对象的反序列化，将硬盘中的对象读取出来
        Person one = new Person("王健林", 18);
        // 创建一个对象序列化流，传进去一个字节输出流
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream("objperson.txt"));
        // 调用序列化流的写方法：writeObject将对象保存到硬盘中，但是被序列化的这个类，需要实现Serializable接口，才可以被序列化
        // 而且保存到硬盘中的序列化后的对象是以二进制保存的，所以我们无法正常查看内容
        objstream.writeObject(one);

        System.out.println("--------------------------------------------------");
        // 对象的反序列化流：将硬盘中保存的序列化对象读取出来，使用Object对象接收，然后可以再进行强转
        ObjectInputStream objinput = new ObjectInputStream(new FileInputStream("objperson.txt"));
        // 使用反序列化的readobject方法，可以将硬盘中的对象读取出来，但是此方法会报一个ClassNotFound异常
        Object obj = objinput.readObject();
        System.out.println(obj.toString());
        // 使用强制转换，将读取到的对象转换成Person类
        Person second = (Person)obj;
        System.out.println(second.getName() + second.getAge());
    }
}
