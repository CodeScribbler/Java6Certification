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

                System.out.println("\n --- BMI-RECHNER ----- \n");
                System.out.println("  Personenübersicht:  1");
                System.out.println("   Person esrtellen:  2");
                System.out.println(" Personen verwalten:  3");
                System.out.println("\n            Beenden:  0");
                System.out.println(" --------------------- \n");

                System.out.print("\n Eingabe: ");
                input = IOTools.readInt();

                if (input > 0 & input <= 3) {

                    switch (input) {
                        case 1:
                            System.out.println("\n#########################\n");
                            for (Person iterator : personen) System.out.println(Ausgabe.gibAusPerson(iterator));
                            System.out.println("\n#########################\n");
                            break;
                        case 2:
                            personen.add(Eingabe.liesPerson());
                            break;
                        case 3:
                            int tmp;
                            do {
                                System.out.println(" ------- Verwaltung --------- \n");
                                System.out.println(" Berechenen Normalgewicht: 1");
                                System.out.println("  Berechenen Idealgewicht: 2");
                                System.out.println("           Berechenen BMI: 3");
                                System.out.println("\n                Abbrechen: 0");
                                System.out.println(" --------------------------- \n");
                                System.out.print("\n\n Eingabe: ");
                                tmp = IOTools.readInt();

                                if (tmp > 0 & tmp <= 3) {

                                    switch (tmp) {
                                        case 1:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Eingabe Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " Normalgewicht: " + personen.get(tmp).getNormalgewicht() + " kg" + "\n\n");
                                                ++tmp;
                                            }
                                            break;
                                        case 2:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Eingabe Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " Idealgewicht: " + personen.get(tmp).getIdealgewicht() + " kg" + "\n\n");
                                                ++tmp;
                                            }
                                            break;
                                        case 3:
                                            tmp = 0;
                                            for (Person iterator : personen) {
                                                System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                                                if (tmp % 2 == 0) System.out.print("\n");
                                            }
                                            System.out.print("\n Eingabe Nr:");
                                            tmp = IOTools.readInt();
                                            if (tmp >= 0 && tmp <= personen.size()) {
                                                System.out.println("\n " + personen.get(tmp).getName() + " BMI: " + personen.get(tmp).getBmiwert() + " kg" + "\n\n");
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