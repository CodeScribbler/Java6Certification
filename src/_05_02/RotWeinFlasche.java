package _05_02;


public class RotWeinFlasche {
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
}
