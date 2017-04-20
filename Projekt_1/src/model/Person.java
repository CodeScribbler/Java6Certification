package model;

public class Person {

    private String name;
    private boolean gender;     // true male, false female
    private int height;
    private float weight;


    public String getName() {
        return name;
    }

    public boolean getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }


    public Person(String name, boolean gender, int height, float weight) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, boolean gender, int height) {
        this(name, gender, height, 80);
    }

    public Person(String name, boolean gender) {
        this(name, gender, 180);
    }

    public Person() {
        this("Max Mustermann", true);
    }


    public float getBmiValue() {
        return Bmi.getBmi(this);
    }

    public float getIdealWeight() {
        return Bmi.getIdealgewicht(this);
    }

    public float getNormalWeight() {
        return Bmi.getNormalgWeight(this);
    }

}