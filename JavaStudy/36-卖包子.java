package DuoThro;

public class BaoZi {
    public static void main(String[] args) {
        System.out.println("老板和顾客做包子的事件：顾客告诉老板要的包子数量，然后开始进去等待状态，老板开始做包子，做好包子后，通知顾客开始吃");
        // obj类中有一个wait方法，可以让线程进入无限等待状态，还有一个notify方法，通知顾客包子已经做好
        Object obj = new Object();
        // 顾客类，顾客告知老板我要的包子，然后进入无限等待状态
        new Thread(){
            @Override
            public void run() {
                // 还需要加上同步代码块，保证通知和等待只有一个在执行
                synchronized (obj){
                    System.out.println("顾客告知老板我要5个包子");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 后面是线程唤醒后执行的代码块
                    System.out.println("顾客拿到老板给的包子开始吃");
                }
            }
        }.start();
        // 创建老板类，开始做包子
        new Thread(){
            @Override
            public void run() {
                // 需要加上同步代码块，保证通知和等待只有一个在执行
                synchronized(obj){
                    System.out.println("老板开始做包子, 请等待5秒钟");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("老板做好了包子，然后通知顾客那包子");
                    obj.notify();
                }
            }
        }.start();

    }
}
