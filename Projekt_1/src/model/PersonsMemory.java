package model;

import util.GenderParseException;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;

public class PersonsMemory {

    private static final File FILE = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PERSONS.csv");
    private static final String DELIMITER = ";";
    private static final String NEW_LINE = "\n";


    public static void writeCsvFile(LinkedList<Person> peopleList) {
        if(!FILE.exists()) FILE.mkdir();

        FileWriter fWriter = null;

        try {
            fWriter = new FileWriter(FILE);

            for (Person iterator : peopleList) {
                fWriter.append(String.valueOf(iterator.getName()));
                fWriter.append(DELIMITER);
                fWriter.append(String.valueOf(iterator.getGender()));
                fWriter.append(DELIMITER);
                fWriter.append(String.valueOf(iterator.getHeight()));
                fWriter.append(DELIMITER);
                fWriter.append(String.valueOf(iterator.getWeight()));
                fWriter.append(NEW_LINE);
            }

            System.out.println("CSV file was created successfully !!!");


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fWriter != null) try {
                fWriter.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void readCsvFile(LinkedList<Person> personsList) {
        if (FILE.exists()) {

            int PERSON_NAME = 0;
            int PERSON_GENDER = 1;
            int PERSON_HEIGHT = 2;
            int PERSON_WEIGHT = 3;


            BufferedReader fReader = null;

            try {
                String line = "";

                fReader = new BufferedReader(new FileReader(FILE));

                while ((line = fReader.readLine()) != null) {

                    String[] tokens = line.split(DELIMITER);

                    if (tokens.length > 0) {
                        Person person = new Person(String.valueOf(tokens[PERSON_NAME]), verifyGender(PERSON_GENDER), Integer.parseInt(String.valueOf(PERSON_HEIGHT)), Float.parseFloat(String.valueOf(PERSON_WEIGHT)));
                        personsList.add(person);
                    }
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else System.out.println(" No file are exist!\n");
    }

    static Gender verifyGender(int PERSON_GENDER) {
        String val = String.valueOf(PERSON_GENDER);
        try {
            return Gender.parseGender(val);
        } catch (GenderParseException e) {
            e.printStackTrace();
        }
        return Gender.UNKNOWN;
    }

}
