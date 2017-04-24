package model;

import java.util.ArrayList;

public class PersonManager {

    public static ArrayList<Person> personsList = new ArrayList<Person>();

    static {
        personsList.add(new Person("Max", Gender.MALE, 180, 80));
        personsList.add(new Person("Sven", Gender.MALE, 174, 76));
        personsList.add(new Person("Sabine", Gender.FEMALE, 160, 60));
        personsList.add(new Person("Michael", Gender.MALE, 176, 80));
        personsList.add(new Person("Christian", Gender.MALE, 183, 92));
        personsList.add(new Person("Marina", Gender.FEMALE, 159, 64));
        personsList.add(new Person("Dave", Gender.MALE, 170, 86));
        personsList.add(new Person("Rheiner", Gender.MALE, 174, 92));
        personsList.add(new Person("Julia", Gender.FEMALE, 169, 80));
        personsList.add(new Person("Daniel", Gender.MALE, 184, 85));
    }

    public static boolean comparePerson(Person obj) {
        for (Person iterator : personsList) {
            if(iterator.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static void bubbleSort(ArrayList<Person> personsList) {
        int out, in;
        for (out = personsList.size() - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (personsList.get(in).getWeight() > personsList.get(in + 1).getWeight()) {
                    swap(personsList, in, in + 1);
                }
            }
        }
    }

    private static void swap(ArrayList<Person> personsList, int one, int two) {
        Person temp = personsList.get(one);
        personsList.set(one, personsList.get(two));
        personsList.set(two, temp);
    }

}