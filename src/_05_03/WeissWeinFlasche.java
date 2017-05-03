package _05_03;

public class WeissWeinFlasche extends Flasche {

    private WeissWein inhalt;

    public boolean istLeer() {
        return this.inhalt == null;
    }

    public void befuellen(WeissWein inhalt) {
        this.inhalt = inhalt;

    }
    public WeissWein leeren() {
        WeissWein temp = this.inhalt;
        this.inhalt = null;
        return temp;

    }

    @Override
    public String toString() {
        return "Flascheninhalt: WeissWein!" + "\n";
    }
}