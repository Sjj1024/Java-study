package FanShe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoTest {
    public static void main(String[] args) throws Exception {
        System.out.println("框架的基础就是反射");
        // 反射：将类的各个组成部分成员变量，构造方法，成员方法，封装为其他对象,这就是反射机制
        // 在程序的运行中，我们就可以操作这些对象。
        // 可以解耦，提高程序的可拓展性

        /*
        * 获取class类对象的方式：三种方式
        * 1、Class.forName("类全名"):将字节码文件加载到内存中，返回class对象,多用于配置文件，将类名定义在配置文件中，读取文件，加载类
        * 2、类名.class：通过类名的属性class获取， 多用于参数的传递，
        * 3、对象.getClass():getClass()方法获取， 多用于对象获取字节码的方式
        * 不论是通过哪种方式加载进来的class对象，都是同一个
        * */
        // 使用第一个方式：
        System.out.println("-----------------------------------------");
        get_class_method1();

        // 类名.class方法
        System.out.println("-----------------------------------------");
        get_class_method2();

        // 通过对象.getClass方法获取类对象
        System.out.println("-----------------------------------------");
        get_class_method3();

        /*
        * 使用class对象：
        * 获取：获取成员变量们，获取构造方法们，获取成员方法们，获取类名
        * getFields，获取成员变量们，返回一个数组
        * */

        // 获取成员方法们
        System.out.println("----------------------------------------");
        get_methods1();
    }

    private static void get_methods1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("获取成员方法们");
        Class<Person> personClass = Person.class;
        Method play = personClass.getMethod("play");
        // 要调用方法，就需要有一个对象
        Person p = new Person();
        Object invoke = play.invoke(p);
        System.out.println(invoke);

        // 调用需要传参的方法，就可以传递进去参数，
        Method show = personClass.getMethod("show", String.class);
        Object res = show.invoke(p, "刺激战场");
        System.out.println(res);

        // 获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            // 获取方法名
            System.out.println(method.getName());
        }
    }

    private static void get_class_method3() throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Class aClass = p.getClass();
        System.out.println(p.toString());
        // 获取成员变量们,getField和getFields
        Field guojia = aClass.getField("guojia");
        // 获取到成员变量后，可以给成员变量设置值和获取其中的值，但是需要传递一个参数，因为这个成员变量属于哪个对象总得有吧
        // 但是需要注意，此方法只能获取到修饰符是public的成员变量
        Object o = guojia.get(p);
        System.out.println(o);
        // 获取到成员变量后，可以通过set设置这个变量的值
        guojia.set(p, "中国");
        System.out.println(p.guojia);
    }

    private static void get_class_method2() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        System.out.println(personClass.toString());
        // 使用getFields可以获取到对象所有public的成员变量
        // 使用getDeclaredFields可以获取到所有的成员变量，不论是不是public修饰的, Declared:公告，宣告
        Field[] fields = personClass.getFields();
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-------------------------------");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // 如果需要访问私有的成员变量，需要使用getDeclaredField方法，需要设置一下访问权限安全检查
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);  // 此处成为暴力反射
        Person p = new Person();
        name.set(p, "王思聪");
        System.out.println(p.toString());
    }

    private static void get_class_method1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("FanShe.Person");
        System.out.println(aClass.toString());
        // 获取构造方法们
        System.out.println("获取构造方法们：");
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor constructor = aClass.getConstructor(String.class, int.class);
        Object wang = constructor.newInstance("王健林", 18);
        System.out.println(wang);
        // 使用空参进行创建对象
        System.out.println("使用空参创建对象");
        Object o = aClass.newInstance();
        System.out.println(o);

    }


}
