package it.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
* 设计模式：23种，常用的有：单例模式，工厂模式，生产者消费者，装饰器模式，代理模式，过滤器模式，迭代器模式
* 其中代理模式和装饰模式都可以增强对象功能，这里使用代理模式举例
* */

public class ProxyTest {

    public static void main(String[] args) {
        Computer lenove = new Computer("联想电脑");

        // 创建一个代理类，传递三个参数，这三个参数是固定套路：被代理类的类加载器，被代理类的接口，Invoke对象，实现invoke方法
        SaleComputer proxy_len = (SaleComputer) Proxy.newProxyInstance(lenove.getClass().getClassLoader(), lenove.getClass().getInterfaces(), new InvocationHandler() {
            // 代理逻辑编写的方法，代理对象调用的所有方法都会被触发该方法执行
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 这里面的三个参数：代理对象，调用的方法名字对象，调用的方法参数
                System.out.println("代理被调用了");
                System.out.println(method.getName());
                System.out.println(args[0]);
                return null;
            }
        });

        // String computer = lenove.saleComputer(8000);
        // 使用代理销售电脑
        String computer = proxy_len.saleComputer(8000);
        System.out.println(computer);

    }
}
