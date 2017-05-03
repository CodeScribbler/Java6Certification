package _05_03;

public class BierFlasche extends Flasche {

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

    @Override
    public String toString() {
        return "Flascheninhalt: Bier!" + "\n";
    }
}