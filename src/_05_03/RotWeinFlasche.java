package _05_03;

public class RotWeinFlasche extends Flasche {

    private RotWein inhalt;

    public boolean istLeer() {
        return this.inhalt == null;
    }

    public void befuellen(RotWein inhalt) {
        this.inhalt = inhalt;

    }
    public Getraenk leeren() {
        RotWein temp = this.inhalt;
        this.inhalt = null;
        return temp;

    }

    @Override
    public String toString() {
        return "Flascheninhalt: RotWein!" + "\n";
    }
}
