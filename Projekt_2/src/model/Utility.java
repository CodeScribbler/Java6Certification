package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class Utility {

    /**
     *
     */
    public static String readString(String prompt) {
        System.out.print(prompt);
        try {
            return new java.util.Scanner(System.in).nextLine();
        }
        catch (NoSuchElementException e) {
            System.err.println(" Ungültige Eingabe!");
        }
        catch (IllegalArgumentException e) {
            System.err.println(" Ungültige Eingabe!");
        }
        return null;
    }

    /**
     *
     */
    public static byte readByte(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextByte();

        }
        catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    /**
     *
     */
    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextInt();

        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    /**
     *
     */
    public static long readLong(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextLong();

        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    /**
     *
     */
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        try {
            return new java.util.Scanner(System.in).nextDouble();
        }
        catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    /**
     *
     */
    public static Date readDate(String prompt) throws ParseException {
        System.out.print(prompt);
        DateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

        return formatter.parse(new java.util.Scanner(System.in).next());
    }

}
