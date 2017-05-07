package Kontoverwaltung.console;

import Kontoverwaltung.model.*;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public final class Input {

    public static boolean createCustomer(Bank bank) {
        String address, phoneNumber, email, firstname, lastname, companyName, contactFirstname, contactLastname, contactPhoneNumber;
        Date birthdate;
        int choice;

        System.out.println("\n - Kundenanlegung wird initialisiert - \n");

        do { address = readString("\n Geben Sie bitte die Adresse eine: "); } while (checkInputCorrection());
        do { phoneNumber = readString("\n Geben Sie bitte die Telefonnummer ein: "); } while (checkInputCorrection());
        do { email = readString("Geben Sie bitte die E-Mailadresse ein: "); } while (checkInputCorrection());


        do {
            choice = readInt("Was wollen Sie anlegen, auswahl per Nr. \n (1) - Privatekunden\n (2) - Firmenkunden\n (3) - Abbrechen");

            switch (choice) {
                case 1:
                    do { firstname = readString("\n Geben Sie bitte den Vornamen ein: "); } while (checkInputCorrection());
                    do { lastname = readString("\n Geben Sie bitte den Nachnamen ein: "); } while (checkInputCorrection());
                    do { birthdate = readDate("\n Geben Sie bitte das Geburtsdatum ein, Formatvorgabe dd.mm.yyyy: "); } while (checkInputCorrection());

                    PrivateCustomer pCustomer = new PrivateCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.PRIVATECUSTOMER, email, firstname, lastname, birthdate);
                    bank.addCustomer(pCustomer);
                    return true;

                case 2:
                    do { companyName = readString("\n Geben Sie bitte den Firmennamen ein: "); } while (checkInputCorrection());
                    do { contactFirstname = readString("\n Geben Sie bitte den Vornamen des Ansprechpartners ein: "); } while (checkInputCorrection());
                    do { contactLastname = readString("\n Geben Sie bitte den Nachnamen des Ansprechpartners ein: "); } while (checkInputCorrection());
                    do { contactPhoneNumber = readString("\n Geben Sie bitte die entsprechende Telefonnummer ein: "); } while (checkInputCorrection());

                    BusinessCustomer bCustomer = new BusinessCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.BUSINESSCUSTOMER, email, companyName, new Counterpart(contactFirstname, contactLastname, contactPhoneNumber));
                    bank.addCustomer(bCustomer);
                    return true;
            }
        }while (choice != 3);
        return false;
    }


    public static boolean createAccount(Bank bank) {
        double accountBalance;

        System.out.println("\n - Kontoanlegung wird initialisiert - \n");
        do { accountBalance = readDouble("Geben Sie bitte den Kontostand ein: "); } while (checkInputCorrection());
        Account acc = new Account(Account.ledgerNumber++, accountBalance);

        bank.printPrivateCustomer();
        bank.printBuisnessCustomer();

        int choice = readInt("\n Zugehöriges Konto, Eingabe Kundennr: ");

        return bank.setAccount(choice, acc);
    }


    private static boolean checkInputCorrection() {
        String input = readString("Soll die Angabe übernommen werden, bestätigung mit Ja oder Nein: ");
        return input.equalsIgnoreCase("j") || input.equalsIgnoreCase("ja");
    }


    public static String readString(String prompt) throws NoSuchElementException, IllegalArgumentException {
        System.out.print(prompt);

        return new java.util.Scanner(System.in).nextLine();
    }


    public static byte readByte(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextByte();

        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }


    public static short readShort(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextShort();

        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }


    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextInt();

        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }


    public static long readLong(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextLong();

        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }


    public static double readDouble(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextDouble();

        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }


    public static Date readDate(String prompt) {
        System.out.print(prompt);
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return formatter.parse(new java.util.Scanner(System.in).next());
        }
        catch (Exception e) { System.out.println(e.getMessage()); }
        return null;
    }


    private Input(){}

}
