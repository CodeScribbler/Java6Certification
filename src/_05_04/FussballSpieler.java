package _05_04;


public class FussballSpieler extends Spieler {

    private int anzahlTore;

    public FussballSpieler(String name) {
        super();
    }


    public void schiessTor() {
        System.out.println("Es wurde ein Tor geschossen!");
        this.anzahlTore++;
    }


    public int anzahlGeschosseneTore() {
        return this.anzahlTore;
    }


}