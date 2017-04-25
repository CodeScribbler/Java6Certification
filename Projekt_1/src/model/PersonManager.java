package model;

import java.util.LinkedList;

public class PersonManager {

    public static LinkedList<Person> peopleList = new LinkedList<Person>();

    static {
        peopleList.add(new Person("Max", Gender.MALE, 180, 80));
        peopleList.add(new Person("Sven", Gender.MALE, 174, 76));
        peopleList.add(new Person("Sabine", Gender.FEMALE, 160, 60));
        peopleList.add(new Person("Michael", Gender.MALE, 176, 80));
        peopleList.add(new Person("Christian", Gender.MALE, 183, 92));
        peopleList.add(new Person("Marina", Gender.FEMALE, 159, 64));
        peopleList.add(new Person("Dave", Gender.MALE, 170, 86));
        peopleList.add(new Person("Rheiner", Gender.MALE, 174, 92));
        peopleList.add(new Person("Julia", Gender.FEMALE, 169, 80));
        peopleList.add(new Person("Daniel", Gender.MALE, 184, 85));
    }

    public static boolean comparePerson(Person obj) {
        for (Person iterator : peopleList) {
            if(iterator.equals(obj)) {
                return true;
            }
        }
        return false;
    }


}