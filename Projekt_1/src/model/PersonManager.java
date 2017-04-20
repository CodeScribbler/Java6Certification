package model;

import io.*;
import util.IOTools;
import java.util.ArrayList;

public class PersonManager {

    private static ArrayList<Person> personen = new ArrayList<Person>(100);

    static {
        personen.add(new Person("Max", true, 180, 80));
        personen.add(new Person("Sven", true, 174, 76));
        personen.add(new Person("Sabine", false, 160, 60));
        personen.add(new Person("Michael", true, 176, 80));
        personen.add(new Person("Christian", true, 183, 92));
        personen.add(new Person("Marina", false, 159, 64));
        personen.add(new Person("Dave", true, 170, 86));
        personen.add(new Person("Sebastian", true, 190, 79));
        personen.add(new Person("Julia", false, 169, 80));
        personen.add(new Person("Daniel", true, 171, 65));
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
                            System.out.println("\n#########################\n");
                            for (Person iterator : personen) System.out.println(Output.printPerson(iterator));
                            System.out.println("\n#########################\n");
                            break;
                        case 2:
                            personen.add(Input.createPerson());
                            break;
                        case 3:
                            int tmp;
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