package JieKou;

// 接口就是一个公共的规范标准,例如插座都是按照接口规范生产de ,接口是一种引用数据类型
// 接口最重要的内容就是其中的抽象方法！
// 新建接口的时候，可以使用上下键选择类或接口
// 接口类最好后面跟上impl，实现接口后，可以使用alt + enter快速实现接口中抽象方法重写

/*
 * 如何定义一个接口：public interface 接口名称{ 接口内容}。其实就是将class换成了interface
 *
 * 接口中可以包含：
 * 常量，抽象方法，默认方法，静态方法，私有方法
 * 在接口的抽象方法中，修饰符必须是两个固定的关键字，public abstrace
 * 这两个关键字修饰符，可以选择性地省略，
 *
 * 接口的使用步骤：
 * 1.接口不能直接使用，必须有一个实现类来实现该接口
 * */
public interface MyInter {
    public abstract void method1();

    public void method2();

    abstract void method3();

    void method4();
}
