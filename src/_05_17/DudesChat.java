package _05_17;

class Dudes {
    static long flag = 0;

    synchronized void chat(long id) {
        if (flag == 0) flag = id;
        for (int x = 1; x < 3; x++) {
            System.out.println(Thread.currentThread().getId());
            if (flag == id) System.out.print("yo");
            else System.out.print("dude");
        }
    }
}

public class DudesChat implements Runnable {
    static Dudes d;

    public static void main(String[] args) {
        new DudesChat().go();
    }

    void go() {

        d = new Dudes();
        new Thread(new DudesChat()).start();
        new Thread(new DudesChat()).start();
    }

    public void run() {
        d.chat(Thread.currentThread().getId());
    }
}

class _ {

    public static void main(String[] args) {
        _ $ = new _();
        f(false, false);
    }

    public static void f(boolean a, boolean b) {
        boolean c;
        boolean d;

        if (!(a || b) && (d=(!(b && !a)))) {
            c = true;
        } else {
            c = false;
        }

        System.out.println(c);
    }
}