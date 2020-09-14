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
