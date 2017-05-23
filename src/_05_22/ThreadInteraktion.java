package _05_22;

public class ThreadInteraktion {
    public static void main(String[] args) {

        Calculator cal = new Calculator();

        Reader r =  new Reader(cal);
        Reader r2 = new Reader(cal);
        Reader r3 = new Reader(cal);

        r.start(); r2.start();r3.start();cal.start();
    }
}

class Reader extends Thread{
    Calculator c;

    public Reader(Calculator c) {
        super();
        this.c = c;
    }
    @Override
    public void run() {
        //Hier soll ein Reader Thread warten bis Calculator mit der Berechnung fertig ist
        synchronized (c) {
            try {
                if(!c.b)	c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(c.total);

    }
}

class Calculator extends Thread{
    int total;
    boolean b = false;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            total += i;
        }

        synchronized (this) {
            this.notifyAll();//notify()
        }
        b = true;

        //thread Calcultor soll mitteilen für die Reader Threads, dass die Berechnung abgeschlossen ist
    }
}