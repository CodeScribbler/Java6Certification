package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
            ExceptionDialog.showDialog(e, null);
        }
        catch (IllegalArgumentException e) {
            ExceptionDialog.showDialog(e, null);
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
            ExceptionDialog.showDialog(e, null);
        }
        catch (NoSuchElementException e) {
            ExceptionDialog.showDialog(e, null);
        }
        catch (IllegalArgumentException e) {
            ExceptionDialog.showDialog(e, null);
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
            ExceptionDialog.showDialog(e, null);
        } catch (NoSuchElementException e) {
            ExceptionDialog.showDialog(e, null);
        } catch (IllegalArgumentException e) {
            ExceptionDialog.showDialog(e, null);
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
            ExceptionDialog.showDialog(e, null);
        } catch (NoSuchElementException e) {
            ExceptionDialog.showDialog(e, null);
        } catch (IllegalArgumentException e) {
            ExceptionDialog.showDialog(e, null);
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
            ExceptionDialog.showDialog(e, null);
        }
        catch (NoSuchElementException e) {
            ExceptionDialog.showDialog(e, null);
        }
        catch (IllegalArgumentException e) {
            ExceptionDialog.showDialog(e, null);
        }
        return -1;
    }

    /**
     *
     * @return
     */
    public static String getDate(String dateString) {
        String formatted;

        DateFormat dfsdf  = new SimpleDateFormat("yyyy-MM-d'T' H:m:s Z");

        if (dateString != null) {
            formatted = dfsdf.format(dateString);
            return dfsdf.format(formatted);
        }
        else
            return dfsdf.format(new Date());
    }

    /**
     *
     * @param dateString
     * @param flag
     * @return
     */
    public static boolean checkDateFormat(String dateString, boolean flag) {
        SimpleDateFormat dateFormat;
        if (flag)
            dateFormat = new SimpleDateFormat("yyyy-MM-d'T' H:m:s Z");
        else
            dateFormat = new SimpleDateFormat("d.MM.yyyy");

        try {
            Date date = dateFormat.parse(dateString);
            dateFormat.format(date);
            return true;
        } catch (ParseException e) {
            String str = "Das Eingelesende Datum (" + dateString + ") ist falsch Formatiert!";
            ExceptionDialog.showDialog(e, str);
        }
        return false;
    }


    private Utility() {}

}
