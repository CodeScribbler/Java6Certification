package model;

import io.*;
import util.Utility;

import java.util.*;

public class Start {

    public static void main(String[] args) {

        showMainMenu(PersonManager.peopleList);
    }

    private static void showMainMenu(LinkedList<Person> personsList) {
        int input;
        do {
            System.out.println("\n --- Bmi Calculator --- \n");
            System.out.println("       Show entries:  1");
            System.out.println("      Create person:  2");
            System.out.println("            Control:  3");
            System.out.println("\n               Exit:  0");
            System.out.println(" --------------------- \n");

            input = Utility.readInt("\n Input: ");

            if (input > 0 & input <= 3) {

                switch (input) {
                    case 1:
                        showEntriesMenu(personsList);
                        break;
                    case 2:
                        personsList.add(Input.createPerson());
                        break;
                    case 3:
                        showControlMenu(personsList);
                        break;
                }
            }
        } while (input != 0);

        System.exit(0);
    }

    private static void showControlMenu(LinkedList<Person> personsList) {
        int val;
        do {
            System.out.println(" ------- Control --------- \n");
            System.out.println(" Calculate normal weight: 1");
            System.out.println("  Calculate ideal weight: 2");
            System.out.println("           Calculate bmi: 3");
            System.out.println("           Export person: 4");
            System.out.println("\n                   Abort: 0");
            System.out.println(" -------------------------- \n");

            val = Utility.readInt("\n Input: ");

            if (val > 0 & val <= 4) {

                switch (val) {
                    case 1:
                        val = 0;
                        for (Person iterator : personsList) {
                            System.out.print(val++ + "). " + iterator.getName() + "  \t ");
                            if (val % 2 == 0) System.out.print("\n");
                        }
                        val = Utility.readInt("\n Input: ");
                        if (val >= 0 && val <= personsList.size()) {
                            System.out.println("\n " + personsList.get(val).getName() + " Normal weight: " + personsList.get(val).getNormalWeight() + " kg" + "\n\n");
                            ++val;
                        }
                        break;
                    case 2:
                        val = 0;
                        for (Person iterator : personsList) {
                            System.out.print(val++ + "). " + iterator.getName() + "  \t ");
                            if (val % 2 == 0) System.out.print("\n");
                        }
                        val = Utility.readInt("\n Input: ");
                        if (val >= 0 && val <= personsList.size()) {
                            System.out.println("\n " + personsList.get(val).getName() + " Ideal weight: " + personsList.get(val).getIdealWeight() + " kg" + "\n\n");
                            ++val;
                        }
                        break;
                    case 3:
                        val = 0;
                        for (Person iterator : personsList) {
                            System.out.print(val++ + "). " + iterator.getName() + "  \t ");
                            if (val % 2 == 0) System.out.print("\n");
                        }
                        val = Utility.readInt("\n Input: ");
                        if (val >= 0 && val <= personsList.size()) {
                            System.out.println("\n " + personsList.get(val).getName() + " BMI: " + personsList.get(val).getBmiValue() + " kg" + "\n\n");
                            ++val;
                        }
                        break;

                    case 4:

                        PersonsMemory.writeCsvFile(personsList);
                        break;
                }
            }

        } while (val != 0);
    }

    private static void showEntriesMenu(LinkedList<Person> personsList) {
        int tmp;
        do {

            System.out.println("\n --- Show entries --- \n");
            System.out.println("      Sort by name:  1");
            System.out.println("    Sort by gender:  2");
            System.out.println("    Sort by weight:  3");
            System.out.println("            Search:  4");
            System.out.println("\n            Exit:  0");
            System.out.println(" --------------------- \n");

            tmp = Utility.readInt("\nInput: ");

            if (tmp > 0 & tmp <= 4) {

                switch (tmp) {
                    case 1:
                        Collections.sort(personsList, new Comparator<Person>() {
                            @Override
                            public int compare(Person first, Person second) {
                                return first.getName().compareTo(second.getName());
                            }
                        });

                        System.out.println("\n####### Sorted by name #######\n");
                        for (Person iterator : personsList) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n##############################\n");
                        break;

                    case 2:
                        Collections.sort(personsList, new Comparator<Person>() {
                            @Override
                            public int compare(Person first, Person second) {
                                return first.getGender().compareTo(second.getGender());
                            }
                        });

                        System.out.println("\n####### Sorted by gender #######\n");
                        for (Person iterator : personsList) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n################################\n");
                        break;

                    case 3:
                        Collections.sort(personsList, new Comparator<Person>() {
                            @Override
                            public int compare(Person first, Person second) {
                                if (first.getWeight() < second.getWeight()) return -1;
                                if (first.getWeight() > second.getWeight()) return 1;
                                return 0;
                            }
                        });
                        System.out.println("\n####### Sorted by weight #######\n");
                        for (Person iterator : personsList) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n################################\n");
                        break;

                    case 4:
                        System.out.println("\n####### Serach by name #######\n");
                        String name = Utility.readString(" Input name: ");
                        name = Start.searchPerson(personsList, name);
                        System.out.println(name);
                        System.out.println("\n##############################\n");
                        break;

                }
            }

        } while (tmp != 0);
    }

    private static String searchPerson(LinkedList<Person> personsList, String name) {
        for (Person iterator : personsList) {
            if(iterator.getName().equalsIgnoreCase(name)) {
                return "\n Search successful! \n" + Output.printPersonWithWeightAndBmi(iterator);
            }
        }
        return "\n Search failed!";
    }

}
