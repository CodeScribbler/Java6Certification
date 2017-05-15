package _05_15;


public class Synchronisation implements Runnable {

    private Account acct = new Account();

    public static void main(String[] args) {

        Synchronisation r = new Synchronisation();

        Thread mann = new Thread(r, "Bob");
        Thread frau = new Thread(r, "Lucy");

        mann.start();
        frau.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithDraw(10);
            if (acct.getBalance() < 10)
                System.out.println("account is overdrawn");
        }
    }

    private synchronized void makeWithDraw(int i) {
        if (acct.getBalance() > i) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acct.withDraw(i);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        }
        else
            System.out.println(Thread.currentThread().getName() + " got nothing!");
    }
}


class Account {

    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withDraw(int amount) {
        this.balance -= amount;
    }

}


