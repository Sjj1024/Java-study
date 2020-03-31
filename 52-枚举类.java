package ZhuJieDemo;

/*
* 枚举类型，可以定义比较简洁的成员属性，这些成员属性都是被final修饰的，所以不能改变，就是常量一样使用
* 被enum修饰的类，称为枚举类，
* */
enum MyMeiJu {
    MONDAY, TWESDAY, THEREDAY, FORDAY, FRIDAY, SATAUSDAY, MONSDAY
}

public class MeiJu{
    public static void main(String[] args) {
        MyMeiJu mj = MyMeiJu.FORDAY;
        System.out.println(mj);
    }
}


