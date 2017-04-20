package _03_30;

public class Initialisierungsblock {

    public static void main(String[] args)  {
        new Teilnehmer("C++", "Berlin");
        new Teilnehmer(111, "C", "Dortmund");
        new Teilnehmer("Peter", 123, "PHP", "Leipzig");
    }

}


class  Teilnehmer {

    private String name;
    private String vorname;
    private int id;
    private String kurs;
    private String standort;


    public String getName() {
        return name;
    }
    public String getVorname() {
        return vorname;
    }
    public int getId() {
        return id;
    }
    public String getKurs() {
        return kurs;
    }
    public String getStandort() {
        return standort;
    }


    {
        System.out.println("Es wird ein Teilnehmer Object konstruiert!");
        this.name = "Philipp";
    }


    public Teilnehmer(String vorname, int id, String kurs, String standort) {
        this.vorname = vorname;
        this.id = id;
        this.kurs = kurs;
        this.standort = standort;
    }

    public Teilnehmer(int id, String kurs, String standort) {
        this.vorname = "Esch";
        this.id = id;
        this.kurs = kurs;
        this.standort = standort;
    }

    public Teilnehmer(String kurs, String standort) {
        this.vorname = "Esch";
        this.id = 123;
        this.kurs = kurs;
        this.standort = standort;
    }

}