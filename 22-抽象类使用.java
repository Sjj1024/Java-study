package JuBu;

/*
* 定义一个动物父类，里面有抽象方法吃东西，抽象方法必须定义在抽象类中
* 如何使用抽象类和抽象方法：
* 1.抽象的类是不能实例化的，因为实例一个动物，没法实现啊，因为动物太多了
* 2.必须使用一个类来继承抽象父类
* 3.子类必须覆盖重写抽象父类中所有的抽象方法，否则的话，子类也必须是一个抽象类
* 4.抽象父类是可以有初始化方法的，
*/
public abstract class Animal {
    String name = "动物类";
    // 定义一个抽象方法：在返回值前加上abstract即可
    public abstract void eat();

    // 定义一个构造方法
    public Animal(){
        System.out.println("抽象父类构造方法被执行");
    }
}


子类继承抽象父类：
package JuBu;

public class Cat extends Animal {
    String name = "我是猫类";

    // 子类必须覆盖重写父类中的抽象方法,为了保险起见，最好写上Override
    @Override
    public void eat(){
        System.out.println("我是猫咪，我喜欢吃鱼");
    }
}



实例化子类对象：
package JuBu;

/*
* 例如有动物类：可以吃东西，还有狗类吃骨头，猫类吃鱼，但是说动物类吃什么？没法定义，因为动物太抽象了，不够具体，
* 再例如有图形，可以计算面积，还有正方形面积是边长平方，三角形面积是地乘高除2，圆形面积πr平方，但是图形的面积怎么算，没法定义，太抽象，没有具体到一个具体的形状
*
* */
public class AbstractLei {
    public static void main(String[] args) {
        Cat ont = new Cat();
        ont.eat();
    }
}
