package DemoZhuJie;


import java.lang.reflect.Method;

/*
* 解析注解：获取注解中的值，并使用注解
* */
@PreDemo(className = "DemoZhuJie.Animal", methodName = "show")
public class UsedAnnotaion {
    public static void main(String[] args) throws Exception {
        // 创建一个本类的字节码文件对象
        Class<UsedAnnotaion> usedAnnotaionClass = UsedAnnotaion.class;
        // 使用本类字节码文件对象获取注解对象，
        PreDemo annotation = usedAnnotaionClass.getAnnotation(PreDemo.class);
        String classname = annotation.className();
        String methodname = annotation.methodName();
        // 打印出获取到的内容
        System.out.println(classname + ":" + methodname);

        // 使用获取到的注解内容，使用反射机制，运行类中的方法
        Class<?> aClass = Class.forName(classname);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodname);
        method.invoke(o);
    }
}
