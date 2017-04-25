package util;

import model.Gender;
import javax.swing.*;
import java.awt.*;
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




}

