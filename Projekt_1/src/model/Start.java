package model;

import io.*;
import util.Utility;

import java.io.Console;
import java.util.*;

public class Start {

    public static void main(String[] args) {

        showMainMenu(PersonManager.personsList);

    }

    private static void showMainMenu(LinkedList<Person> personsList) {
        int input;
        do {
            System.out.println("\n - Weight calculator - ");
            System.out.println("      Create person:  1");
            System.out.println("      Delete person:  2");
            System.out.println("      Serach person:  3");
            System.out.println("           Overview:  4");
            System.out.println("           Settings:  5");
            System.out.println(" - - - - - - - - - - - ");
            System.out.println("               Exit:  0");
            System.out.println(" --------------------- \n");

            input = Utility.readInt("\n Input: ");

            if (input > 0 & input <= 5) {

                switch (input) {
                    case 1:
                        personsList.add(Input.createPerson());
                        break;

                    case 2:
                        PersonManager.deletePerson();
                        break;

                    case 3:
                        PersonManager.searchPerson();
                        break;

                    case 4:
                        showOverviewMenu(personsList);
                        break;

                    case 5:
                        showSettingsMenu();
                        break;
                }
            }
        } while (input != 0);

        System.exit(0);
    }

    private static void showOverviewMenu(LinkedList<Person> personsList) {
        int input;
        do {

            System.out.println("\n ------- Overview ------- ");
            System.out.println("            Sort by name:  1");
            System.out.println("          Sort by gender:  2");
            System.out.println("             Sort by bmi:  3");
            System.out.println(" - - - - - - - - - - - - - -");
            System.out.println(" Calculate normal weight:  4");
            System.out.println("  Calculate ideal weight:  5");
            System.out.println("           Calculate bmi:  6");
            System.out.println(" - - - - - - - - - - - - - -");
            System.out.println("                    Back:  0");
            System.out.println(" --------------------------- \n");

            input = Utility.readInt("\n Input: ");

            if (input > 0 & input <= 6) {

                int value;
                switch (input) {
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
                                if (first.getBmiValue() < second.getBmiValue()) return -1;
                                if (first.getBmiValue() > second.getBmiValue()) return 1;
                                return 0;
                            }
                        });
                        System.out.println("\n####### Sorted by bmi ##########\n");
                        for (Person iterator : personsList) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n################################\n");
                        break;

                    case 4:
                        PersonManager.printPersons();

                        value = Utility.readInt("\n Input: ");
                        if (value >= 0 && value <= personsList.size()) {
                            System.out.println("\n " + personsList.get(value).getName() + " Normal weight: " + personsList.get(value).getNormalWeight() + " kg" + "\n\n");
                            ++value;
                        }
                        break;

                    case 5:
                        PersonManager.printPersons();

                        value = Utility.readInt("\n Input: ");
                        if (value >= 0 && value <= personsList.size()) {
                            System.out.println("\n " + personsList.get(value).getName() + " Ideal weight: " + personsList.get(value).getIdealWeight() + " kg" + "\n\n");
                            ++value;
                        }
                        break;

                    case 6:
                        PersonManager.printPersons();

                        value = Utility.readInt("\n Input: ");
                        if (value >= 0 && value <= personsList.size()) {
                            System.out.println("\n " + personsList.get(value).getName() + " BMI: " + personsList.get(value).getBmiValue() + " kg" + "\n\n");
                            ++value;
                        }
                        break;
                }
            }

        } while (input != 0);
    }

    private static void showSettingsMenu() {
        int val;
        do{
            System.out.println(" -------- Settings --------- ");
            System.out.println("           Export person: 1");
            System.out.println("           Import person: 2");
            System.out.println(" - - - - - - - - - - - - - ");
            System.out.println("                    Back: 0");
            System.out.println(" -------------------------- \n");

            val = Utility.readInt("\n Input: ");

            if (val > 0 & val <= 2) {

                switch (val) {
                    case 1:

                        PersonManager.writeCsvFile();
                        break;

                    case 2:

                        PersonManager.readCsvFile();
                        break;
                }
            }

        } while(val != 0);
    }

}