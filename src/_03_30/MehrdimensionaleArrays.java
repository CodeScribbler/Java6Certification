package _03_30;

class MehrdimensionaleArrays {

    public static void main(String... args) {
        new d(); new d();
    }

}

class Bird {
    { System.out.print("b1 "); }
    public Bird() { System.out.print("b2 "); }
}
class Raptor extends Bird {
    static { System.out.print("r1 "); }
    public Raptor() { System.out.print("r2 "); }
    { System.out.print("r3 "); }
    static { System.out.print("r4 "); }
}
class Hawk extends Raptor {
    public static void main(String[] args) {
        System.out.print("pre ");
        new Hawk();
        System.out.println("hawk ");
    }
}

class InstanceStatischeInintBlocks {


    {

    }

    public InstanceStatischeInintBlocks() {

    }
}

class c {

    {
        System.out.println("C inst init block 1");
    }

    static {
        System.out.println("C static init block");
    }

    {
        System.out.println("C inst init block 2");
    }

    c() {
        System.out.println("C construktor");
    }
}

class d  extends c{

    {
        System.out.println("d inst init block 1");
    }

    static {
        System.out.println("d static init block");
    }

    {
        System.out.println("d inst init block 2");
    }

    d() {
        System.out.println("d construktor");
    }

}