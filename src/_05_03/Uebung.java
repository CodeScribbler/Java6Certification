package _05_03;

public class Uebung {

    public static void main(String[] args) {

        Kasten kasten = new Kasten(50);

        kasten.add(new BierFlasche());
        kasten.add(new WeissWeinFlasche());
        kasten.add(new RotWeinFlasche());

        kasten.printKasten();

    }

}
