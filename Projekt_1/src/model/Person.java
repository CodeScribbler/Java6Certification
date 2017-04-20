package model;

public class Person {

    private String name;
    private boolean geschlecht;             // true ist Männlich, false ist Weiblich
    private int koerpergroesse;
    private float gewicht;


    public String getName() {
        return name;
    }

    public boolean getGeschlecht() {
        return geschlecht;
    }

    public int getKoerpergroesse() {
        return koerpergroesse;
    }

    public float getGewicht() {
        return gewicht;
    }


    public Person(String name, boolean geschlecht, int koerpergroesse, float gewicht) {
        this.name = name;
        this.geschlecht = geschlecht;
        this.koerpergroesse = koerpergroesse;
        this.gewicht = gewicht;
    }

    public Person(String name, boolean geschlecht, int koerpergroesse) {
        this(name, geschlecht, koerpergroesse, 80);
    }

    public Person(String name, boolean geschlecht) {
        this(name, geschlecht, 180);
    }

    public Person() {
        this("Max Mustermann", true);
    }


    //protected float berechneMeinGewicht(Person obj) {}

    public float getBmiwert() {
        return Bmi.getBmi(this);
    }

    public float getIdealgewicht() {
        return Bmi.getIdealgewicht(this);
    }

    public float getNormalgewicht() {
        return Bmi.getNormalgewicht(this);
    }

}