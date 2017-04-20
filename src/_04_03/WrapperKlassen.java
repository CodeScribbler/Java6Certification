package _04_03;

public class WrapperKlassen {
    public static void main() {
        int i = 1, j = 2, k = 3;
        Box b1 = new Box(i);
        Box b2 = new Box(j);
        Box b3 = new Box(k);

        Integer eingabe = new Integer(5);
    }

}





class Box {

    int i;

    public Box(int i) {
        this.i = i;
    }
}