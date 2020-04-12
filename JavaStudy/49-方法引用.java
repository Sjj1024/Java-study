package MethodYinYong;

public class UseYinyong {
    public static void main(String[] args) {
        System.out.println("使用方法引用实现调用lambda表达式");
        // 创建一个方法，可以传递一个函数式接口,函数式接口可以用Lambda表达式表示，而lambda表达式可以用方法引用表示
//        String name = "nihao";
        // 此时name1 -> System.out.println(name1)实现了一个匿名内部类重新定义了接口中的方法体，而接口只是定义了方法名字，没有实现具体的方法体
        // 此时System.out.println(name1)就相当于方法体，将函数式接口传递进来的参数name1给打印出去了
        method_yinyong(name1 -> System.out.println(name1));

        // 此时因为可以传递lambda表达式，所以也可以传递方法引用，就是用已经存在的对象，引用其中的方法
        method_yinyong(Student::strToUpperCase);
    }

    private static void method_yinyong(MethodInterface me) {
        // 只是调用这个接口中的方法，并没有实现方法体，方法体还是在lambda表达式中实现的
        me.mehtod("nihao");
    }
}
