package _05_02;

public class FlascheG<ABC extends Getraenk> {//T ist platzhalter für bel Referenzdatentyp
    private ABC inhalt;

    public boolean istLeer() {
        return this.inhalt == null;
    }

    public void befuellen(ABC inhalt) {
        this.inhalt = inhalt;

    }
    public ABC leeren() {
        ABC temp = this.inhalt;
        this.inhalt = null;
        return temp;

    }

    public void test(){
        System.out.println(inhalt.hashCode());
        System.out.println(inhalt.toString());
    }
}