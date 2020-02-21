package ObjSome;

public class Student {
    private String name;
    private int age;
    static String room = "北京222班";  // 此时教室将会共用此属性；一旦被赋值，所有对象共用
    private int id;
    static int idcount; // 通过创建对象时候自动增加实现每个用户有唯一ID

    public static void staticmethod(){
        System.out.println("此方法是静态方法，属于类方法，可以直接使用类名称调用");
    }

    public void method(){
        System.out.println("此方法是对象方法，必须创建对象后才可以使用");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
        idcount++;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
