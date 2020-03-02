package DuoTai;

/*
* 多态指的多种形态：发生在继承的基础之上，可以是类与类继承，也可以是接口继承或实现，
* 左父右子就叫多态，例如：父类名称 对象名 = new 子类名称（）
* 或者接口：接口名称 对象名 = new 实现类名称()
* */
public class test {
    public static void main(String[] args) {
        // 使用多态创建对象
        TestFu first = new TestSon();
        first.Say();

        // 使用接口创建子类对象
        TestInter second = new TestSon();
        second.Flay();
    }
}
