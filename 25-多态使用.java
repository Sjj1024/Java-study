package DuoTai;

/*
* 多态指的多种形态：发生在继承的基础之上，可以是类与类继承，也可以是接口继承或实现，
* 左父右子就叫多态，例如：父类名称 对象名 = new 子类名称（），例如一只猫被当做动物类看待，
* 或者接口：接口名称 对象名 = new 实现类名称()  一只鸟可以有飞的接口
*
* 编译看左边，运行看右边，也就是说编译的时候优先查看左边父类的内容，如果没有就报错，
* 运行的时候看右边new的是谁，如果没有，就想上查找！
* */
public class test {
    public static void main(String[] args) {
        // 使用多态创建对象
        TestFu first = new TestSon();
        first.Say();

        // 成员变量的使用没有任何变化,使用的还是父类中的变量，因为变量是不能覆盖重写的
        System.out.println(first.name);

        // 子类使用了自己的变量方法
        first.ShouName();

        // 使用接口创建子类对象
        TestInter second = new TestSon();
        second.Flay();
    }
}
