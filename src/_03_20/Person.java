package _03_20;

public class Person {

    private String name;
    private int alter;
    private char geschlecht;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }
    public void setAlter(int alter) {
        this.alter = alter;
    }

    public char getGeschlecht() {
        return geschlecht;
    }
    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Person(String name, int alter, char geschlecht) {
        this.name = name;
        this.alter = alter;
        this.geschlecht = geschlecht;
    }

    public Person(String name, int alter) {
        this(name, alter, 'M');
    }

    public Person(String name) {
        this(name, 21, 'm');
    }

    public Person() {
        this("Max", 21, 'M');
    }

}