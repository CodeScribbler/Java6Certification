package console;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Input {

    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[d][e]$", Pattern.CASE_INSENSITIVE);

    //  Static methods

    /**
     *
     * @param prompt
     * @return
     */
    private static String emailValidation(String prompt) {
        String email = Input.readString(prompt);
        Matcher matcher = VALID_EMAIL.matcher(email);

        if (matcher.find()) return email;

        return null;
    }

    /**
     *
     */
    public static boolean createBuisnessCustomer(Bank bank) {
        String address, phoneNumber, email, companyName, contactFirstname, contactLastname, contactPhoneNumber;

        System.out.println("\n - Buisness Kundenanlegung wird initialisiert - \n");

        do {
            companyName = readString("\n Eingabe Firmenname: ");
        } while (!checkInputCorrection());
        do {
            contactFirstname = readString("\n Eingabe Ansprechpartner-Vorname: ");
        } while (!checkInputCorrection());
        do {
            contactLastname = readString("\n Eingabe Ansprechpartner-Nachname: ");
        } while (!checkInputCorrection());
        do {
            contactPhoneNumber = readString("\n Eingabe Telefonnummer: ");
        } while (!checkInputCorrection());

        do {
            address = readString("\n Eingabe Adresse: ");
        } while (!checkInputCorrection());
        do {
            phoneNumber = readString("\n Geben Sie bitte die Telefonnummer ein: ");
        } while (!checkInputCorrection());
        do {
            email = emailValidation("\n Eingabe E-Mail Adresse: ");
            if (email == null)
                System.out.print(" Ungültige E-Mail-Adresse!\n");
        } while (email == null || (!checkInputCorrection()));

        return bank.addCustomer(new BusinessCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.BUSINESSCUSTOMER, email, companyName, new Counterpart(contactFirstname, contactLastname, contactPhoneNumber)));

    }

    /**
     *
     */
    public static boolean createPrivateCustomer(Bank bank) {
        String address, phoneNumber, email, firstname, lastname;
        Date birthdate = null;

        System.out.println("\n - Private Kundenanlegung wird initialisiert - \n");

        do {
            firstname = readString("\n Eingabe Vorname: ");
        } while (!checkInputCorrection());

        do {
            lastname = readString("\n Eingabe Nachname: ");
        } while (!checkInputCorrection());

        do {
            address = readString("\n Eingabe Adresse: ");
        } while (!checkInputCorrection());

        do {
            phoneNumber = readString("\n Eingabe Telefonnummer: ");
        } while (!checkInputCorrection());

        do {
            email = emailValidation("\n Eingabe E-Mail Adresse: ");
            if (email == null)
                System.out.print(" Ungültige E-Mail Adresse!\n");
        } while (email == null || (!checkInputCorrection()));

        do {
            try {
                birthdate = readDate("\n Eingabe Geburtsdatum, Formatvorgabe dd.mm.yyyy: ");
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while (birthdate == null || (!checkInputCorrection()));

        return bank.addCustomer(new PrivateCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.PRIVATECUSTOMER, email, firstname, lastname, birthdate));

    }

    /**
     *
     */
    public static boolean createAccount(Bank bank) {
        double accountBalance;

        System.out.println("\n - Kontoanlegung wird initialisiert - \n");
        do {
            accountBalance = readDouble("Geben Sie bitte den Kontostand ein: ");
        } while (!checkInputCorrection());
        Account acc = new Account(Account.ledgerNumber++, accountBalance);

        bank.printPrivateCustomer(bank.getSortedCustomerList(false));
        bank.printBuisnessCustomer(bank.getSortedCustomerList(false));

        int choice = readInt("\n Zugehöriges Konto, Eingabe Kundennr: ");

        return bank.setAccount(choice, acc);
    }

    /**
     *
     */
    private static boolean checkInputCorrection() {
        String input = readString(" Eingabe bestätigen mit Ja oder Nein: ");
        return input.equalsIgnoreCase("j") || input.equalsIgnoreCase("ja");
    }

    /**
     *
     */
    public static String readString(String prompt) throws NoSuchElementException, IllegalArgumentException {
        System.out.print(prompt);

        return new java.util.Scanner(System.in).nextLine();
    }

    /**
     *
     */
    public static byte readByte(String prompt) {
        System.out.print(prompt);
        try {

            return new java.util.Scanner(System.in).nextByte();

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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


    //  Constructor

    private Input() {
    }

}
