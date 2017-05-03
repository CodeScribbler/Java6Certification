package _05_02;

public class BierFlasche {
    private Bier inhalt;

    public boolean istLeer() {
        return this.inhalt == null;
    }

    public void befuellen(Bier inhalt) {
        this.inhalt = inhalt;

    }
    public Bier leeren() {
        Bier temp = this.inhalt;
        this.inhalt = null;
        return temp;

    }
}
