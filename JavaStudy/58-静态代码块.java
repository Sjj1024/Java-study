package DanTest;

public class JDBCUtils {

    private static String name;
    int age;

    static {
        // System.out.println("开始给静态代码块中的属性赋值");
        name = "王思松";
        // 只有属性是静态的，才可以在静态代码块中使用
        // age = 10;
    }

    public void method1() {
        // 可以直接使用属性，也可以使用this.
        System.out.println(name + this.age);
    }

}
