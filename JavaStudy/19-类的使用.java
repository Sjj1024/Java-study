package ObjThree;

/*
 * 面向对象的三大特性：封装，继承，多态，
 * 封装：保护代码不被外界随意调用的目的，
 * 继承：提高代码的重复利用
 * 多态：建立在继承基础上，一龙生九子，九子个不同
 *
 * 如果子类和父类拥有相同的属性，则直接通过子类对象访问成员变量，等号左边是谁，就优先用谁，没有则向上查找
 * 局部变量:直接在方法体重使用即可，
 * 本类变量：使用this关键字调用
 * 父类变量：使用super关键字调用
 *
 *  方法的覆盖重写：父类中已经定义的方法，子类中重写了这个方法，就叫方法的覆盖重写
 *  super的父类构造方法只能有一个，而且必须是在第一行，
 * */
public class Student extends Person {
    int age = 0;

    public Student(){
        // 自己类中的构造方法会自动调用父类中的构造方法，赠送的super（）
        System.out.println("学生类中的构造方法！");
    }

    public void study(){
        System.out.println("我要好好学习！");
    }

    public void testint(){
        int num = 88;
        System.out.println(num);
        System.out.println(this.age);
        System.out.println(super.name);
    }

    public void say(){
        // 调用父类的方法，再增加自己的方法
        super.say();
        System.out.println("我会说英语");
        System.out.println("我会说中文");
    }
}
