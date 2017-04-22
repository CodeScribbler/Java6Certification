package util;

import model.Gender;
import model.Person;
import model.PersonManager;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

    private static Scanner input = new Scanner(System.in);


    public static String readString(String prompt) {
        System.out.print(prompt);

        return input.nextLine();
    }

    public static float readFloat(String prompt) {
        System.out.print(prompt);
        try {
            return Float.parseFloat(input.nextLine());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0.0F;
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(input.nextLine());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static Gender readGender(String prompt) {
        System.out.print(prompt);
        try {
            return Gender.parseGender(input.nextLine());

        } catch (GenderParseException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void serializationPerson(Person person) {
        ObjectOutputStream objOutStream = null;

        try {
            objOutStream = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PersonBackup\\" + "PERSON - " + person.getName() + ".txt")));
            objOutStream.writeObject(person);
            objOutStream.flush();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NotSerializableException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objOutStream != null) objOutStream.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void deserializationPerson(ArrayList<Person> personsList) {
        File dir = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PersonBackup\\");
        try {
            if (isDirNotEmpty(dir)) {

                int i = 0;
                File[] filesList = dir.listFiles();
                for(File f : filesList){
                    if(f.isFile()){
                        System.out.print(i++ + ") - " + f.getName());
                    }
                }
                int val;
                do {
                    val = readInt("Choose which person should be inserted by nr: ");
                } while(val >= 0 && val <= i);

                String filename = "";

                ObjectInputStream objOutStream = null;
                try {
                    objOutStream = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PersonBackup\\" + filename)));
                    Person obj = (Person) objOutStream.readObject();

                    if (PersonManager.comparePerson(obj)) {
                        System.out.println(" The person is already exist!");
                    }
                    else {
                        personsList.add(obj);
                        System.out.println("The person is succesful inserted!");
                    }

                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally{
                    try {
                        if(objOutStream != null)objOutStream.close();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            else System.out.println("No backup files are exist!\n");

        } catch (IOException e) { JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
    }

    private static boolean isDirNotEmpty(File dir) throws IOException {
        if (dir.isDirectory() && dir.exists()) {
            if (dir.list().length > 0)
                return true;     // Directory is not empty
        } else {
            return false;        // Directory is empty");
        }
    }

}

