package Lesson_5;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();

//        Thread t1 = new Thread(new MyRunnableClass());
//        Thread t2 = new Thread(new MyRunnableClass());
//
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(i);
//                }
//            }
//        });
//
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(i);
//                }
//            }
//        });
//
//        t2.start();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("2");
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("END");
    }
}

class MyRunnableClass implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(i);
        }
    }
}
