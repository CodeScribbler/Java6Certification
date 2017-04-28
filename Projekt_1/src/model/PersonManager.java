package model;

import io.Output;
import util.GenderParseException;
import util.Utility;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;

public class PersonManager {

    private static final File FILE = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PERSONS.csv");

    public static LinkedList<Person> personsList = new LinkedList<Person>();

    static {
        personsList.add(new Person("Max", Gender.MALE, 180, 80.5F));
        personsList.add(new Person("Sven", Gender.MALE, 174, 76.7F));
        personsList.add(new Person("Sabine", Gender.FEMALE, 160, 60.2F));
        personsList.add(new Person("Michael", Gender.MALE, 176, 80.9F));
        personsList.add(new Person("Christian", Gender.MALE, 183, 92.0F));
        personsList.add(new Person("Marina", Gender.FEMALE, 159, 64.7F));
        personsList.add(new Person("David", Gender.MALE, 170, 86.6F));
        personsList.add(new Person("Reiner", Gender.MALE, 174, 92.2F));
        personsList.add(new Person("Julia", Gender.FEMALE, 169, 80.4F));
        personsList.add(new Person("Dirk", Gender.MALE, 184, 85.1F));
    }

    public static void deletePerson() {
        int input;

        printPersons();

        input = Utility.readInt("\n Input: ");

        if (input >= 0 && input < personsList.size()) {
            personsList.remove(input);
            System.out.println("\n The person has been successfully deleted!");
        }
        else System.err.println("\n Wrong input!");


    }

    public static void printPersons() {
        int val = 0;
        System.out.print("\n");
        for (Person iterator : personsList) {
            System.out.print(val++ + " - " + iterator.getName() + "  \t\t ");
            if (val % 2 == 0) System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void searchPerson() {
        System.out.println("\n####### Serach by name #######\n");
        String name = Utility.readString(" Input name: ");

        for (Person iterator : personsList) {
            if(iterator.getName().equalsIgnoreCase(name)) {
                System.out.println("\n Search successful! \n" + Output.printPersonWithWeightAndBmi(iterator));
                System.out.println("\n##############################\n");
                return;
            }
        }

        System.err.println("\n Search failed!");
        System.out.println("\n##############################\n");
    }

    public static void writeCsvFile() {
        BufferedWriter fWriter = null;

        try {
            fWriter = new BufferedWriter(new FileWriter(FILE));

            for (Person iterator : personsList) {
                fWriter.write(String.valueOf(iterator.getName()));
                fWriter.write(";");
                fWriter.write(String.valueOf(iterator.getGender()));
                fWriter.write(";");
                fWriter.write(String.valueOf(iterator.getHeight()));
                fWriter.write(";");
                fWriter.write(String.valueOf(iterator.getWeight()));
                fWriter.write("\n");
            }

            System.out.println("\n\nCSV file was created successfully!\n\n");


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (fWriter != null) try {
                fWriter.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void readCsvFile() {
        if (FILE.exists()) {

            int NAME = 0;
            int GENDER = 1;
            int HEIGHT = 2;
            int WEIGHT = 3;


            BufferedReader fReader = null;

            try {
                String line = "";

                fReader = new BufferedReader(new FileReader(FILE));

                while ((line = fReader.readLine()) != null) {

                    String[] tokens = line.split(";");

                    if (tokens.length > 0) {
                        Person person = new Person(String.valueOf(tokens[NAME]),
                                                   Gender.parseGender(tokens[GENDER].substring(0,1)),
                                                  Integer.parseInt(String.valueOf(HEIGHT)),
                                                    Float.parseFloat(String.valueOf(WEIGHT)));

                        personsList.add(person);
                    }
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (GenderParseException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else System.err.println("\n No file are exist!\n");
    }

}