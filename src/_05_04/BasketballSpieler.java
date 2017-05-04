package _05_04;


public class BasketballSpieler extends Spieler {

    private int punkte;

    public BasketballSpieler(String name) {
        super();
    }

    public void wirfKorb() {
        System.out.println("Es wurde ein gepunktet!");
    }

    public int erzieltePunkte() {
        return this.punkte;
    }
}
