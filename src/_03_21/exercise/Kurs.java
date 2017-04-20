package _03_21.exercise;

public class Kurs {

    private float raumNr;
    private String fach;
    private String dozent;
    private Teilnehmer[] teilnehmer;

    public float getRaumNr() {
        return raumNr;
    }
    public void setRaumNr(int raumNr) {
        this.raumNr = raumNr;
    }

    public String getFach() {
        return fach;
    }
    public void setFach(String fach) {
        this.fach = fach;
    }

    public String getDozent() {
        return dozent;
    }
    public void setDozent(String dozent) {
        this.dozent = dozent;
    }

    public Teilnehmer[] getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(Teilnehmer[] teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    public Kurs(int kapazität, int raumNr, String dozent, String fach) {
        this.teilnehmer = new Teilnehmer[kapazität];
        this.raumNr = raumNr;
        this.dozent = dozent;
        this.fach = fach;
    }

    @Override
    public String toString() {
        return " Fach: " + this.getFach() + "\n Raum: " + this.raumNr
                + "\n Dozent: " + this.getDozent() + "\n Maximale Teilnehmeranzahl : " + getTeilnehmer().length
                + "\n Aktuelle Teilnehmer: " + getTeilnehmerNamen(this.teilnehmer);
    }

    private String getTeilnehmerNamen(Teilnehmer[] arr) {
        String strKette = null;
        for (Teilnehmer pointer : arr) {
            if(pointer != null) {
                strKette += pointer.getName() + "\n ";
            }
        }
        return strKette;
    }

    public void ausgeben() {
        System.out.println(this.toString());
    }

}