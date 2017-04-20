package _04_03;

public class Main {
    public static void main(String[] args) {
        Auto a = new Auto(12, new Rad(3));
        int a3 = 3, b = 5;
        a = go(a3, b);


    }
    public static Auto go(int i, int j) {
        Rad r1 = new Rad(i);
        Auto a2 = new Auto(i, r1);
        return a2;
    }
}

class Auto {
    int x;
    Rad r;
    public Auto(int x, Rad r) {
        this.x = x;
        this.r = r;
    }
}
class Rad {
    int n;
    public Rad(int n) {
        this.n = n;
    }
}