package _05_15;

public class Exercise extends Thread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
                try {
                    sleep(250);
                }
                catch (InterruptedException e) {
                    System.err.print(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Exercise()).start();
    }

}
