package _05_22;

/*
 * Was ist das?
 * Potenziele Ursachen für Deadlock
 *
 * Fragenformen:
 * 				-theoretische (Verständnis)
 * 				-Code Fragment wird gegeben,
 * 				-untersuche, ob Deadlock vorkommen kann
 *
 * 	Eine der Ursache für Deadlock ist "falsche" Synchronisation
 *
 */

public class DeadLock {

    static Object Lock1 = new Object();
    static Object Lock2 = new Object();


    public void m1() {
        synchronized(Lock1) {
            synchronized (Lock2) {
                go();
            }
        }
    }

    public void m2() {
        synchronized(Lock1) {
            synchronized (Lock2) {
                go();
            }
        }
    }

    private void go() {
        System.out.println("Goooooo!");
    }

    public static void main(String[] args) {
        A a = new A();
        a.ma(new Object());
        a.getA();
        a.foo();

        B b = new B();
        b.mb();
        b.boo();
    }
}


class A{
    private B b = new B();
    public synchronized void ma(Object oa) {
        goA(oa);
        b.mb();
    }
    private void goA(Object o) {
        // TODO Auto-generated method stub

    }
    public synchronized Object getA() {
        return  foo();
    }
    public Object foo(){
        return new Object();
    }
}


class B{
    private A a = new A();
    public synchronized void mb() {
        goB();
    }
    private void goB() {
        // TODO Auto-generated method stub

    }
    public synchronized void boo(){
        Object o = a.foo();
    }

}