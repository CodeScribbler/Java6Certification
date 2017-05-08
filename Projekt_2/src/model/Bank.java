package model;

import console.Input;
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.List;

/**
 *  Die Klasse Bank beinhaltet neben der Adresse
 *  und Identifikationsnummer..
 */
public class Bank {

    // Attributes

    /**
     *  Name der Bank
     */
    private String name;

    /**
     *  BIC
     */
    private String identifierCode;

    /**
     *  Teil 1 der Bankadresse.
     */
    private String address1;

    /**
     *  Teil 2 der Bankadresse.
     */
    private String address2;

    /**
     *  Postleitzahl der Bank.
     */
    private short zipcode;


    // Field with initializer and methods

    /**
     *
     */
    private List<Customer> customerList = new ArrayList<Customer>();

    {
        Customer obj;
        DateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

        try {

            customerList.add(obj = new PrivateCustomer(Customer.ID++, "MusterStraße 1", "0221-15555", CustomerTyp.PRIVATECUSTOMER, "example1@whatever.com", "Max", "Mustermann", formatter.parse("01.01.1975")));
            customerList.add(obj = new PrivateCustomer(Customer.ID++, "MusterStraße 2", "0221-25555", CustomerTyp.PRIVATECUSTOMER, "example2@whatever.com", "Diana", "Musterfrau", formatter.parse("18.11.1976")));
            customerList.add(obj = new PrivateCustomer(Customer.ID++, "MusterStraße 3", "0221-35555", CustomerTyp.PRIVATECUSTOMER, "example3@whatever.com", "Reiner", "Mustermann", formatter.parse("08.12.1974")));
            customerList.add(obj = new PrivateCustomer(Customer.ID++, "MusterStraße 4", "0221-45555", CustomerTyp.PRIVATECUSTOMER, "example4@whatever.com", "Sabrina", "Musterfrau", formatter.parse("05.10.1973")));
            customerList.add(obj = new PrivateCustomer(Customer.ID++, "MusterStraße 5", "0221-55555", CustomerTyp.PRIVATECUSTOMER, "example5@whatever.com", "Dirk", "Mustermann", formatter.parse("15.04.1972")));

            customerList.add(obj = new BusinessCustomer(Customer.ID++, "MusterStraße 6", "0221-65555", CustomerTyp.BUSINESSCUSTOMER, "example6@whatever.com", "Consulting aAa", new Counterpart("Dave", "Nobody", "0221-115555")));
            customerList.add(obj = new BusinessCustomer(Customer.ID++, "MusterStraße 7", "0221-75555", CustomerTyp.BUSINESSCUSTOMER, "example7@whatever.com", "Consulting bBb", new Counterpart("Chris", "Nobody", "0221-125555")));
            customerList.add(obj = new BusinessCustomer(Customer.ID++, "MusterStraße 8", "0221-85555", CustomerTyp.BUSINESSCUSTOMER, "example8@whatever.com", "Consulting cCc", new Counterpart("Darrel", "Nobody", "0221-135555")));
            customerList.add(obj = new BusinessCustomer(Customer.ID++, "MusterStraße 9", "0221-95555", CustomerTyp.BUSINESSCUSTOMER, "example9@whatever.com", "Consulting dDd", new Counterpart("Jack", "Nobody", "0221-145555")));
            customerList.add(obj = new BusinessCustomer(Customer.ID++, "MusterStraße 10", "0221-105555", CustomerTyp.BUSINESSCUSTOMER, "example10@whatever.com", "Consulting eEe", new Counterpart("Michael", "Nobody", "0221-155555")));

        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     */
    public boolean addCustomer(Customer obj) {
        return this.customerList.add(obj);
    }

    /**
     *
     */
    public List<Customer> getSortedCustomerList(boolean sorted) {
        List<Customer> result = new ArrayList<Customer>(customerList);
        if (sorted)
            Collections.sort(result, byId);

        return result;
    }

    /**
     *
     */
    public boolean printAllAccounts() {
        boolean returnVal = false;
        for (Customer INDEX : this.customerList) {
            if (INDEX.getAccountSize() > 0) {
                returnVal = true;
                INDEX.printAccounts();
            }
        }
        return returnVal;
    }

    /**
     *
     */
    public void printBuisnessCustomer(List<Customer> cList) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (Customer index : cList) {
            if (index instanceof BusinessCustomer)
                formatter.format("%3d %11s %17s %21s %n", index.getCustomerId(), ((BusinessCustomer) index).getCompanyName(), ((BusinessCustomer) index).getContact().getFirstName(), ((BusinessCustomer) index).getContact().getFirstName());
        }
        System.out.printf("Übersicht Firmenkunden:%n| %1s | %10s | %14s |%n", "ID", "Firmenname", "Ansprechpartner Vor- Nachname");
        System.out.println(sb);
    }

    /**
     *
     */
    public void printPrivateCustomer(List<Customer> cList) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (Customer index : cList) {
            if (index instanceof PrivateCustomer)
                formatter.format("%3d %11s %17s %n", index.getCustomerId(), ((PrivateCustomer) index).getFirstName(), ((PrivateCustomer) index).getLastname() );
        }
        System.out.printf("Übersicht Privatkunden:%n| %1s | %10s | %14s |%n", "ID", "Vorname", "Nachname");
        System.out.println(sb);
    }

    /**
     *
     */
    public boolean setAccount(int id, Account acc) {
        for (Customer index : customerList) {
            if(index instanceof PrivateCustomer) {
                if (index.getCustomerId() == id) return index.addAccount(acc);
            }
            if(index instanceof BusinessCustomer) {
                if (index.getCustomerId() == id) return index.addAccount(acc);
            }
        }
        return false;
    }

    /**
     *
     */
    public boolean searchCustomer(String option) {
        System.out.println("\n - Kundensuche wird initialisiert - \n");
        int id;
        String name;
        if (option.equalsIgnoreCase("byID")) id = Input.readInt("\n Geben Sie bitte die KdNr ein: ");
        else
            {
                name = Input.readString("\n Geben Sie bitte den Namen ein: ");
                for (Customer INDEX : customerList) {
                    if (INDEX instanceof PrivateCustomer)
                        if (((PrivateCustomer) INDEX).getLastname().equalsIgnoreCase(name)) id = INDEX.getCustomerId();
                    if (INDEX instanceof BusinessCustomer)
                        if (((BusinessCustomer) INDEX).getCompanyName().equalsIgnoreCase(name)) id = INDEX.getCustomerId();
            }
            return false;
        }
        for (Customer INDEX : customerList) {
            if (INDEX instanceof PrivateCustomer) {
                if (INDEX.getCustomerId() == id) {
                    System.out.println("\n " + ((PrivateCustomer) INDEX).getFirstName() + " - " + ((PrivateCustomer) INDEX).getLastname());
                    INDEX.printAccounts();
                    return true;
                }
            }
            if (INDEX instanceof BusinessCustomer) {
                if (INDEX.getCustomerId() == id) {
                    System.out.println("\n " + ((BusinessCustomer) INDEX).getCompanyName());
                    INDEX.printAccounts();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     */
    public boolean searchAccount() {
        long iban = Input.readLong("\n Geben Sie bitte die IBAN ein: ");
        for (Customer index : customerList) {
            List<Account> accList = index.getAccounts();
            for (Account pointer : accList) {
                if(pointer.getAccountNumber() == iban) {
                    System.out.println("\n IBAN: " + pointer.getAccountNumber() + " Kontostand: " + pointer.getAccountBalance());
                    return true;
                }
            }
        }
        return false;
    }


    // Comparator sort by Id

    /**
     *
     */
    private final static Comparator<Customer> byId = new Comparator<Customer>() {
        @Override
        public int compare(Customer first, Customer second) {
            return first.getCustomerId() > second.getCustomerId() ? -1 : first.getCustomerId() < second.getCustomerId() ? +1 : 0;
        }
    };


    // Constructor

    /**
     *  Anwendung des singleton Muster, um zu gewährleiten
     *  das es nur eine Instanz dieses Objektes gibt.
     */
    private Bank() {
        this.name ="Alteingesessene Berliner Bank";
        this.identifierCode = "DEUT DEDB 110";
        this.address1 = "Breite Straße";
        this.address2 = "33-34";
        this.zipcode = 10435;
    }

    /**
     *  Statische erzeugung der Bank Instanz.
     */
    private static Bank ourInstance = new Bank();

    /**
     *  Die statische Methode gibt die Referrenz
     *  auf die singleton Instanz zurueck.
     *
     * @return  Die Referrenz auf die Bank Instanz.
     */
    public static Bank getInstance() {
        return ourInstance;
    }

}
