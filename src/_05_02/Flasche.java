package _05_02;

public class Flasche {
    private Getraenk inhalt;

    public boolean istLeer() {
        return this.inhalt == null;
    }

    public void befuellen(Getraenk inhalt) {
        this.inhalt = inhalt;

    }
    public Getraenk leeren() {
        Getraenk temp = this.inhalt;
        this.inhalt = null;
        return temp;

    }
}
