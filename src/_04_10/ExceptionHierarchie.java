package _04_10;

public class ExceptionHierarchie {

    public static void main(String[] args) {

        try {
            go(3);
        }
        catch (C e) {
            System.out.println(e.getMessage());
        }
        catch (B e) {
            System.out.println(e.getMessage());
        }
        catch (A e) {
            System.out.println(e.getMessage());
        }
    }

    public static void go(int i) throws A, B, C {
        if(i == 0) throw new A();
        if(i == 1) throw new B();
        if(i == 2) throw new C();
        System.out.println(i);
    }

}


class A extends Exception {

}
class B extends A {

}
class C extends B {

}