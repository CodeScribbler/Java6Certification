package model;

import io.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Start {

    private static BufferedReader in;
    private static StringTokenizer input;

    public static void main(String[] args) {

        startMenu(PersonManager.personen);
    }


    private static void startMenu(ArrayList<Person> personen) {
        int input;
        do {
            System.out.println("\n --- Bmi Calculator --- \n");
            System.out.println("       Show entries:  1");
            System.out.println("      Create person:  2");
            System.out.println("            Control:  3");
            System.out.println("\n                 Exit:  0");
            System.out.println(" --------------------- \n");

            input = Start.readInt("\n Input: ");

            if (input > 0 & input <= 3) {

                switch (input) {
                    case 1:
                        showEntriesMenu(personen);
                        break;
                    case 2:
                        personen.add(Input.createPerson());
                        break;
                    case 3:
                        subMenuControl(personen);
                        break;
                }
            }
        } while (input != 0);

    }

    private static void subMenuControl(ArrayList<Person> personen) {
        int tmp;
        do {
            System.out.println(" ------- Control --------- \n");
            System.out.println(" Calculate normal weight: 1");
            System.out.println("  Calculate ideal weight: 2");
            System.out.println("           Calculate bmi: 3");
            System.out.println("\n                   Abort: 0");
            System.out.println(" -------------------------- \n");

            tmp = Start.readInt("\n Input: ");

            if (tmp > 0 & tmp <= 3) {

                switch (tmp) {
                    case 1:
                        tmp = 0;
                        for (Person iterator : personen) {
                            System.out.print(tmp++ + "). " + iterator.getName() + "  \t ");
                            if (tmp % 2 == 0) System.out.print("\n");
                        }
                        tmp = Start.readInt("\n Input: ");
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
                        tmp = Start.readInt("\n Input: ");
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
                        tmp = Start.readInt("\n Input: ");
                        if (tmp >= 0 && tmp <= personen.size()) {
                            System.out.println("\n " + personen.get(tmp).getName() + " BMI: " + personen.get(tmp).getBmiValue() + " kg" + "\n\n");
                            ++tmp;
                        }
                        break;
                }
            }

        } while (tmp != 0);
    }

    private static void showEntriesMenu(ArrayList<Person> personen) {
        int tmp;
        do {

            System.out.println("\n --- Show entries --- \n");
            System.out.println("             Regular:  1");
            System.out.println("      Sorted by name:  2");
            System.out.println("    Sorted by gender:  3");
            System.out.println("              Search:  4");
            System.out.println("\n              Exit:  0");
            System.out.println(" --------------------- \n");

            tmp = Start.readInt("\nInput: ");

            if (tmp > 0 & tmp <= 4) {

                switch (tmp) {
                    case 1:
                        Collections.sort(personen);
                        System.out.println("\n########## Regular #########\n");
                        for (Person iterator : personen) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n#########################\n");
                        break;
                    case 2:
                        Collections.sort(personen, new sortedByName());
                        System.out.println("\n########## By name #########\n");
                        for (Person iterator : personen) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n#########################\n");
                        break;
                    case 3:
                        Collections.sort(personen, new sortedByGender());
                        System.out.println("\n########## By Gender #########\n");
                        for (Person iterator : personen) System.out.println(Output.printPerson(iterator));
                        System.out.println("\n#########################\n");
                        break;
                    case 4:
                        String name = Start.readLine("\n Input name: ");
                        int val = Collections.binarySearch(personen, new Person("Philipp", Gender.MALE, 192, 95), new sortedByGender());
                }
            }

        } while (tmp != 0);
    }


    public static String readLine(String prompt) {
        System.out.print(prompt);
        try {
            return in.readLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);;
        }
        return null;
    }

    public static float readFloat(String prompt) {
        System.out.print(prompt);
        try {
            return Float.parseFloat(input.nextToken());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
        }
        return 0.0F;
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(input.nextToken());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static Gender readGender(String prompt) {
        System.out.print(prompt);
        try {
            return Gender.parseGender(input.nextToken());

        } catch (GenderParseException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
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



