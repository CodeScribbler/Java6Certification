package _03_29;

public class Scope {

    static int sa = 123;
    int ia;

    {
        ia = 9;
        int x = 13;
    }

    public Scope() {
        ia += 4;
        int y = 10;
    }

    public void go() {
        int z = 0;
        System.out.println(ia);
        for (int i = 0; i < 3; i++) {
            z += i + ia;
            System.out.println(z);
        }
    }

    public static void main(String[] args) {
        Scope obj = new Scope();
        obj.go();
    }

}