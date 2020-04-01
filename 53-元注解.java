package ZhuJieDemo;


import java.lang.annotation.*;

/*
* 注解的属性：也就是接口中的抽象方法
* 要求：属性的返回值类型有下列取值，基本数据类型，string，枚举，注解，以上类型的数组
* 使用注解的时候，需要给属性赋值，如果使用了default关键字，则可以不赋值
*
* 元注解：@Target，@Retention，@Documented，@Inherited
* @Target 用于描述注解的作用范围,一般都是任何类型
* @Retention 描述注解的生命周期，有源文件，class文件，runtime阶段
* @Inherited 用于描述该注解是否支持被继承，如果被此注解修饰的类，其子类也会继承此注解
* @Documented是生成doc文档时是否显示在文档中
* */
@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyZhujie {
    String getname();
    int getage();

}
