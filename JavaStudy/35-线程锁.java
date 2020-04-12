package DuoThro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MaiPiao implements Runnable {
    int all_piao = 100;

//    @Override
//    public void run() {
//        System.out.println("开始执行买票操作");
//        while (all_piao > 0) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String name = Thread.currentThread().getName();
//            System.out.println(name + "正在卖第"+ all_piao + "张票");
//            all_piao--;
//        }
//    }
    // 使用同步代码块解决安全问题:创建同步代码块，随机创建一个锁对象，将访问到共享数据的代码，放到同步代码块中
    // 先创建一个锁对象，锁可以是任意的对象,但是需要频繁的判断锁，
//    Object obj = new Object();
//    @Override
//    public void run() {
//        synchronized(obj){
//            while (all_piao > 0) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                String name = Thread.currentThread().getName();
//                System.out.println(name + "正在卖第" + all_piao + "张票");
//                all_piao--;
//            }
//        }
//    }


    // 使用同步方法解决线程安全问题，将访问到共享数据的代码块抽取出来，放到一个方法中，然后调动这个方法
    // 其实同步方法默认是将锁对象换成了Runnable对象，也就是this
//    @Override
//    public void run() {
//        sail_piao();
//    }
//
//    public synchronized void sail_piao() {
//        while (all_piao > 0) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String name = Thread.currentThread().getName();
//            System.out.println(name + "正在卖第" + all_piao + "张票");
//            all_piao--;
//        }
//    }

    // 在成员位置处，使用Lock锁接口中的Reentrant对象创建一个锁对象，然后在共享数据代码前调用lock方法，在共享数据后调用unlock方法
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        // 在共享代码开始前上锁
        l.lock();
        try {
            while (all_piao > 0) {
                Thread.sleep(10);
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖第" + all_piao + "张票");
                all_piao--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 在共享代码块后释放锁：更好的写法是将释放锁放到finally中,无论程序是否出现异常，都可以释放锁
            l.unlock();
        }
    }
}


