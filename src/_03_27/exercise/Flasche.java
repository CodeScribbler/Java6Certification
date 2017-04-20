package _03_27.exercise;

/**
 *
 * Modelliert eine Flasche mit Inhalt und Volumen
 *
 */
public class Flasche {
    /** Attribute */
    private String inhalt;
    private int volumen; // in Millilitern

    /**
     * @param inhalt
     * @param volumen
     */
    public Flasche(String inhalt, int volumen) {
        super();
        this.inhalt = inhalt;
        this.volumen = volumen;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Diese Flasche beinhaltet " + inhalt + " und hat das Volumen " + volumen + "ml";
    }

}