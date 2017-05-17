package _05_17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class GlobalLock {
    static Lock lock = new ReentrantLock();

    static void lock() { lock.lock(); }
    static void unlock() { lock.unlock(); }
//	static void lock() { }
//	static void unlock() { }
}


class Adder extends Thread {
    @Override
    public void run() {
        while (true) {
            GlobalLock.lock();
            for (int i = 0; i < 10; i++) {
                LockSmithing.count++;
            }
            GlobalLock.unlock();
        }
    }
}

class Remover extends Thread {
    @Override
    public void run() {
        while (true) {
            GlobalLock.lock(); // synchronized (GlobalLock.class) {
            try {
                for (int i = 0; i < 10; i++) {
                    LockSmithing.count--;
                }
            }
            finally {
                GlobalLock.unlock();
            }
        }
    }
}

class Printer extends Thread {
    int runs = 20;

    @Override
    public void run() {
        while (--runs > 0) {
            GlobalLock.lock();
            int now = LockSmithing.count;
            GlobalLock.unlock();
            int diff = now - LockSmithing.last;
            LockSmithing.last = now;
            System.out.println(String.format("Now: %d, Diff: %d", now, diff));
            Util.sleep(500);
        }
    }
}


public class LockSmithing {
    static int count = 0;
    static int last = 0;

    public static void main(String[] args) {
        new Adder().start();
        new Remover().start();
        Thread p = new Printer(); p.start();
        Util.join(p);
        System.exit(0);
    }

}

class Util {
    // Sleeping tightly
    static void sleep() { sleep(0, 0); }
    static void sleep(long millis) { sleep(millis, 0); }
    static void sleep(long millis, int nanos) {
        try {
            Thread.sleep(millis, nanos);
        } catch (InterruptedException irrelevant) {}
    }

    // Joining relaxedly
    static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException irrelevant) {}
    }
}