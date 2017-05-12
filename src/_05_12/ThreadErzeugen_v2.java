package _05_12;


public class ThreadErzeugen_v2 {


    class MyThread1 extends Thread {
        public MyThread1(Runnable r, String name) {
            super(r, name);
        }
    }


    class MyThread2 extends Thread {
        public MyThread2(Runnable r, String name) {
            super(r, name);
        }
    }


    public static void main(String[] args) {

        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    System.out.println(Thread.currentThread().getName() + " gibt aus: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new ThreadErzeugen_v2().new MyThread1(target, "Thread-1").start();

        new ThreadErzeugen_v2().new MyThread2(target, "Thread-2").start();


        new Thread(target,"Thread-3") {}.start();

        new Thread(target,"Thread-4") {}.start();

    }

}
