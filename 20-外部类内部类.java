package QuanXian;

public class Test {
    public static void main(String[] args) {
        // 外部类调用内部类:直接方式，在外部类的方法中，使用内部类，然后main只是调用外部类的方法
        // 直接方法：外部类名称.内部类名称 对象名=new 外部类名称().new 内部类名称();
        Lei first = new Lei();
        first.shuo();

        // 按照公式进行调用
        System.out.println("---------------");
        Lei.nei second = new Lei().new nei();
        second.tiao();
        
    }
}


内外部类定义格式：
package QuanXian;

/*
* 成员内部类，局部内部类
* 成员内部类：
*   修饰符 class 外部类名称{
*       修饰符 class 内部类名称{
*           内部类可以随意调用外部类，外部类不能随意调用内部
*       }
*   }
* */
public class Lei { // 外部类

    public class nei{
        // 内部类
        public void tiao(){
            System.out.println("内部类心脏跳动");
        }

    }

    // 定义一个外部类私有的属性
    private String name = "小明";

    // 外部类成员变量
    public void shuo(){
        System.out.println("外部类会说话,调用内部心脏跳动");
        new nei().tiao();
    }



}
