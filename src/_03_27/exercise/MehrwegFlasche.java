package _03_27.exercise;

/**
 * Modelliert eine MehrwegFlasche, die Inhalt, Volumen und Pfand hat.
 */

public class MehrwegFlasche extends Flasche {

    /** Attribute */
    private String inhalt;
    private int volumen;
    private int pfand; //in cent

//    public String getInhalt() {
//        return inhalt;
//    }
//    public void setInhalt(String inhalt) {
//        this.inhalt = inhalt;
//    }
//
//    public int getVolumen() {
//        return volumen;
//    }
//    public void setVolumen(int volumen) {
//        this.volumen = volumen;
//    }
//
//    public int getPfand() {
//        return pfand;
//    }
//    public void setPfand(int pfand) {
//        this.pfand = pfand;
//    }

    /** Methoden */

    public MehrwegFlasche(String inhalt, int volumen, int pfand) {
        super(inhalt,volumen);
        this.pfand = pfand;
    }

    @Override
    public String toString() {
        return super.toString() + " und hat einen Pfandbetrag von: " + this.pfand + " Cent";
    }
}