package ZhuJieDemo;


/*
* jdk中已经安排的几个常用注解使用和介绍
* override 方法被重写了
* deprecated 表示方然已过期，不建议使用了，但是仍然可以使用，只不过在使用的时候，会有一道中横线
* suppresswarnings 压制警告,写到哪个方法或者类上后，这个类或者方法就没有警告了
*
* */
// 需要传参，一般都是all
@SuppressWarnings("all")
public class MostUse {
    String name;


    /**
     * 此处的Override就是方法被重写了
     * @return
     */
    @Override
    public String toString() {
        return "MostUse{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Deprecated 方法被弃用了，不建议使用
     */
    public void method1() {
        System.out.println("方法已经被弃用了");
    }
}
