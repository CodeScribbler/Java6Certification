package _05_03;


import java.util.Arrays;

public class Kasten<T extends Flasche> {

    private Flasche[] kasten;
    private int count;

    public Kasten(int capacity) {
        this.kasten = new Flasche[capacity];
    }

    public void add(T flasche)   {
        this.kasten[count++] = flasche;
    }

    public T getFlasche(int index) {
        if (index > kasten.length-1 || index < 0) System.out.println("Die Flasche konnte nicht gefunden werden!");

        return (T) this.kasten[index];
    }

    public void printKasten() {
        for (int i = 0; i <kasten.length ; i++) {
            System.out.println(kasten[i] instanceof BierFlasche);
            System.out.println(kasten[i] instanceof RotWeinFlasche);
            System.out.println(kasten[i] instanceof WeissWeinFlasche);
        }
    }

    @Override
    public String toString() {
        return "Kasten:\n" + Arrays.toString(kasten);
    }
}
