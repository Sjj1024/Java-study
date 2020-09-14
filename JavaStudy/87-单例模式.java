package com.shen.utils;


public class single {
    // 使用静态内部类实现单例模式
    private void single() {

    }

    public static class Inner {
        public static final single InstanceOne = new single();
    }


    public static single getSingle() {
        return Inner.InstanceOne;
    }


}


测试类中创建单例实例对象，并比较他们的hashcode
    @Test
    public void CommSingle() {
//        single.Inner inner = new single.Inner();
        single getSingle = single.getSingle();
        single getSingle2 = single.getSingle();
        System.out.println(getSingle.hashCode());
        System.out.println(getSingle2.hashCode());
        System.out.println(getSingle == getSingle2);

    }
