package model;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Serializable, Comparable<Person> {

    private String name;
    private Gender gender;
    private int height;
    private float weight;


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }


    public Person(String name, Gender gender, int height, float weight) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, Gender gender, int height) {
        this(name, gender, height, 80);
    }

    public Person(String name, Gender gender) {
        this(name, gender, 180);
    }

    public Person() {
        this("Max Mustermann", Gender.MALE);
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


    @Override
    public int compareTo(Person obj) {
        if(this.name.equalsIgnoreCase(obj.getName())) return 1;
		else return 0;
    }
}

class sortedByName implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

class sortedByGender implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}