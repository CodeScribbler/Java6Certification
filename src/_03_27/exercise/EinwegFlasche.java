package _03_27.exercise;

/**
 *
 * Modelliert eine einwegflasche, die Inhalt, Volumen und eine mögliche Zulassung für den grünen Punkt - Muel hat
 *
 */
public class EinwegFlasche extends Flasche {

    private String inhalt;
    private int volumen;
    private boolean hatGruenenPunkt;

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
//    public boolean isHatGruenenPunkt() {
//        return hatGruenenPunkt;
//    }
//
//    public void setHatGruenenPunkt(boolean hatGruenenPunkt) {
//        this.hatGruenenPunkt = hatGruenenPunkt;
//    }

    /** Methoden */

    public EinwegFlasche(String inhalt, int volumen, boolean hatGruenenPunkt) {
        super(inhalt,volumen);
        this.hatGruenenPunkt = hatGruenenPunkt;
    }

    @Override
    public String toString() {
        return super.toString() + " und hat einen Grünen Punkt: " + Boolean.toString(this.hatGruenenPunkt);
    }

}
