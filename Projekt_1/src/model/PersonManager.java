package model;

import io.*;
import util.IOTools;
import java.util.ArrayList;
import java.util.Collections;

public class PersonManager {

    private static ArrayList<Person> personen = new ArrayList<Person>(100);

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


    public static void startMenu() {
        try {

            int input;

            do {

                View.mainMenu();

                System.out.print("\n Input: ");
                input = IOTools.readInt();

                if (input > 0 & input <= 3) {

                    switch (input) {
                        case 1:
                            int tmp;
                            do {

                                View.showEntriesMenu();

                                System.out.print("\n\n Input: ");
                                tmp = IOTools.readInt();

                                if (tmp > 0 & tmp <= 4) {

                                    switch (tmp) {
                                        case 1:
                                            System.out.println("\n########## Regular #########\n");
                                            for (Person iterator : personen)
                                                System.out.println(Output.printPerson(iterator));
                                            System.out.println("\n#########################\n");
                                            break;
                                        case 2:
                                            Collections.sort(personen, new sortedByName());
                                            System.out.println("\n########## By name #########\n");
                                            for (Person iterator : personen)
                                                System.out.println(Output.printPerson(iterator));
                                            System.out.println("\n#########################\n");
                                            break;
                                        case 3:
                                            Collections.sort(personen, new sortedByGender());
                                            System.out.println("\n########## By Gender #########\n");
                                            for (Person iterator : personen)
                                                System.out.println(Output.printPerson(iterator));
                                            System.out.println("\n#########################\n");
                                            break;
                                        case 4:
                                            System.out.println("\n Input name: ");
                                            String name = IOTools.readString();
                                            System.out.println(Collections.binarySearch(personen, name), new sortedByName());


                                    }
                                }

                            } while (tmp != 0);

                        case 2:
                            personen.add(Input.createPerson());
                            break;
                        case 3:
                            do {
                                System.out.println(" ------- Control --------- \n");
                                System.out.println(" Calculate normal weight: 1");
                                System.out.println("  Calculate ideal weight: 2");
                                System.out.println("           Calculate bmi: 3");
                                System.out.println("\n                   Abort: 0");
                                System.out.println(" --------------------------- \n");

                                System.out.print("\n\n Input: ");
                                tmp = IOTools.readInt();

                                if (tmp > 0 & tmp <= 3) {

                                    switch (tmp) {
                                        case 1:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Input Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " Normal weight: " + personen.get(tmp).getNormalWeight() + " kg" + "\n\n");
                                                ++tmp;
                                            }
                                            break;
                                        case 2:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Input Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " Ideal weight: " + personen.get(tmp).getIdealWeight() + " kg" + "\n\n");
                                                ++tmp;
                                            }
                                            break;
                                        case 3:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Input Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " BMI: " + personen.get(tmp).getBmiValue() + " kg" + "\n\n");
                                                ++tmp;
                                            }
                                            break;
                                    }
                                }

                            } while (tmp != 0);
                    }
                }

            } while (input != 0);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}