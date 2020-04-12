package IOliu;

import ObjThree.Person;
import demo.list.ArrayListDemo1;

import java.io.*;
import java.util.ArrayList;

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

        // 类中的静态关键static是和对象没有关系的，而且静态优先于类加载到内存中，所以序列化的时候，是不能保存静态内容的
        // 瞬态关键字也是一样，不能在序列化的时候将内容保存到硬盘中,transient修饰的内容，默认保存的都是默认值

        // 当发生InvalidClassException异常的时候，可能是序列化的时候和反序列化的时候，类中做了修改，导致类的版本号不一样，所以报异常
        // 解决此问题的方法就是在类中定义自己的版本号，无论类怎么变化，都使用同一个版本号，就不会报错了
        // 定义自己版本号方法：private static final long serialVersionUID = 42L;后面的版本号随意写

        System.out.println("---------------------------------------------");
        //序列化集合：将对象保存到集合中，然后序列化的时候，就直接写入集合，读取的时候，读到的也是一个集合，需要强转成集合，然后再遍历内容
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("王健林", 45));
        list.add(new Person("王思聪", 23));
        list.add(new Person("王巴丹", 42));
        list.add(new Person("王铁蛋", 23));
        // 创建一个对象序列化流
        ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("listobj.txt"));
        objout.writeObject(list);
        objout.close();
        // 创建一个对象反序列化流
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream("listobj.txt"));
        Object three = objin.readObject();
        ArrayList<Person> list2 = (ArrayList<Person>) three;
        System.out.println(list2);
        for (Person person : list2) {
            System.out.println(person.getName() + person.getAge());
        }
    }
}
