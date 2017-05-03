package _05_02;


public class WeissWeinFlasche {
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
}
