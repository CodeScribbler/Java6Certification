package model;

import java.util.ArrayList;

public class PersonManager {

    public static ArrayList<Person> personen = new ArrayList<Person>();

    static {
        personen.add(new Person("Max", Gender.MALE, 180, 80));
        personen.add(new Person("Sven", Gender.MALE, 174, 76));
        personen.add(new Person("Sabine", Gender.FEMALE, 160, 60));
        personen.add(new Person("Michael", Gender.MALE, 176, 80));
        personen.add(new Person("Christian", Gender.MALE, 183, 92));
        personen.add(new Person("Marina", Gender.FEMALE, 159, 64));
        personen.add(new Person("Dave", Gender.MALE, 170, 86));
        personen.add(new Person("Sebastian", Gender.MALE, 190, 79));
        personen.add(new Person("Julia", Gender.FEMALE, 169, 80));
        personen.add(new Person("Daniel", Gender.MALE, 171, 65));

    }
}