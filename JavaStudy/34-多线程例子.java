package DuoThro;

public class NiMingThread {
    public static void main(String[] args) {
        System.out.println("使用匿名内部类实现多线程");
        // 子类或实现类对象，可以简化代码：new Thread
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("线程:" + i);
                }
            }
        };
        t.start();

        // 使用匿名接口实现线程
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("接口" + i);
                }
            }
        };
        new Thread(run).start();

        // 还可以使用更简单的代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("更简单"+i);
                }
            }
        }).start();


        // 主线程中的循环遍历
        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}
