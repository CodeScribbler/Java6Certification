package _05_05;

import java.util.Comparator;

public class Teilnehmer {

    private String kurs;
    private int kursdauer;
    private String name;

    public Teilnehmer(String kurs, int kursdauer, String name) {
        this.kurs = kurs;
        this.kursdauer = kursdauer;
        this.name = name;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public int getKursdauer() {
        return kursdauer;
    }

    public void setKursdauer(int kursdauer) {
        this.kursdauer = kursdauer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teilnehmer{" +
                "kurs='" + kurs + '\'' +
                ", kursdauer=" + kursdauer +
                ", name='" + name + '\'' +
                '}';
    }


    public final static Comparator<Teilnehmer> nachName = new Comparator<Teilnehmer>() {
        @Override
        public int compare(Teilnehmer first, Teilnehmer second) {
            return first.getName().compareTo(second.getName());
        }
    };

    public final static Comparator<Teilnehmer> nachKurs = new Comparator<Teilnehmer>() {
        @Override
        public int compare(Teilnehmer first, Teilnehmer second) {
            return first.getKurs().compareTo(second.getKurs());
        }
    };


}
