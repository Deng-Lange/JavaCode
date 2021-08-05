package test;

//class MyThread extends Thread {
//    // 继承自 Thread 的子类, 必须要实现一个 run 这样的方法
//    // run 方法里面就包含了该新线程要执行的代码逻辑是啥
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("hello");
//        }
//    }
//}

public class TestThread {
    public static void main(String[] args) {
        // MyThread t = new MyThread();
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello");
                }
            }
        };
        // 使用 Thread 类的 start 方法在系统中创建一个线程
        // 其实程序一启动的时候, main 方法, 就对应到一个线程了.
        // 再次 Thread.start 又创建出一个线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main");
        }
    }
}