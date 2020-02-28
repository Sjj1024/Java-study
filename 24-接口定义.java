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
 *
 * 默认方法：为了解决接口升级的问题，定义格式：
 * public default void 方法名字(){方法体}
 * 实现类中不必覆盖这个默认方法，仍然可以使用这个接口类，并使用这个默认方法
 *
 * 接口是一种极度抽象的类型，它比抽象类更加“抽象”,因为接口只定义了方法，一般不定义属性，而类具有对象的层次，
 * 比如插座接口，并不需要一个类，只需要按照指定的规范方法实现，就可以了，
 *
 * 对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；
 * 而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。
 *
 * 接口中也可以定义自己的成员常量：但必须使用public static final三个关键字修饰
 * 从效果上看，这其实就是接口的常量，格式：public static final 数据类型 常量名称 = 数值；
 * 一旦被final修饰符修饰，说明不可以更改！
 *
 * 接口当中的常量可以省略public static final，不写，也照样不可修改
 * 使用的时候，使用接口名.常量名称
 * 
 * 一个类只能继承一个父类，但是可以实现多个接口，用逗号隔开
 * */
public interface MyInter {
    public abstract void method1();

    public void method2();

    abstract void method3();

    void method4();

    // 定义默认方法接口，其中public 可以省略不写，
    public default void methoddefault(){
        System.out.println("我是接口中的默认方法");
    }

    // java8中可以在接口中定义静态方法，调用的时候，使用接口.静态方法
    // public 可以省略,不能使用实现类对象调用接口静态方法
    public static void methodstatic(){
        System.out.println("接口中的静态方法！");
    }

    // 定义接口中的常量：一定进行明确的赋值
    public static final int NUM_CLASS = 12;
}
