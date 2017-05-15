package _05_15;


public class JoinSleep {

    public static void main(String[] args) throws InterruptedException {

        Thread[] ts = { new Thread(new work(), "t1"), new Thread(new work(), "t2"), new Thread(new work(), "t3")};

        ts[0].start();

        try {
            ts[0].join(2000);
        }
        catch (InterruptedException e) {
            System.err.print(e.getMessage());
        }

        ts[1].start();

        try {
            ts[0].join();
        }
        catch (InterruptedException e) {
            System.err.print(e.getMessage());
        }

        ts[2].start();
        try {
            ts[0].join();ts[1].join();ts[2].join();
        } catch (InterruptedException e) {
            System.err.print(e.getMessage());
        }

    }

}


class work implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread gestartet: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.print(e.getMessage());
        }
        System.out.println("Thread terminiert:" + Thread.currentThread().getName());
    }
}