package model;

import java.text.*;
import java.util.*;
import java.util.List;

/**
 * Die Klasse Bank beinhaltet neben der Adresse
 * und Identifikationsnummer..
 */
public class Bank {

    // Attributes

    /**
     * Name der Bank
     */
    private String name;

    /**
     * BIC
     */
    private String identifierCode;

    /**
     * Teil 1 der Bankadresse.
     */
    private String address1;

    /**
     * Teil 2 der Bankadresse.
     */
    private String address2;

    /**
     * Postleitzahl der Bank.
     */
    private short zipcode;


    private int bankCode;


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

        } catch (ParseException e) {
            System.err.println(e.getMessage());
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
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();

        for (Customer INDEX : this.customerList) {
            if (INDEX.getAccountSize() > 0) {
                accounts.addAll(INDEX.getAccounts());
            }
        }
        return accounts;
    }

    /**
     *
     */
    public boolean setAccount(int id, Account acc) {
        for (Customer index : customerList) {
            if (index instanceof PrivateCustomer) {
                if (index.getCustomerId() == id) return index.addAccount(acc);
            }
            if (index instanceof BusinessCustomer) {
                if (index.getCustomerId() == id) return index.addAccount(acc);
            }
        }
        return false;
    }

    /**
     *
     */
    public List<Account> searchCustomer(int id, String name) {
        if (name != null) {
            for (Customer INDEX : customerList) {
                if (INDEX instanceof PrivateCustomer)
                    if (((PrivateCustomer) INDEX).getLastname().equalsIgnoreCase(name)) id = INDEX.getCustomerId();
                if (INDEX instanceof BusinessCustomer)
                    if (((BusinessCustomer) INDEX).getCompanyName().equalsIgnoreCase(name)) id = INDEX.getCustomerId();
                else
                    return null;
            }
        }

        for (Customer INDEX : customerList) {
            if (INDEX instanceof PrivateCustomer) {
                if (INDEX.getCustomerId() == id) {
                    System.out.println("\n " + ((PrivateCustomer) INDEX).getFirstName() + " - " + ((PrivateCustomer) INDEX).getLastname());
                    return INDEX.getAccounts();
                }
            }
            if (INDEX instanceof BusinessCustomer) {
                if (INDEX.getCustomerId() == id) {
                    System.out.println("\n " + ((BusinessCustomer) INDEX).getCompanyName());
                    return INDEX.getAccounts();
                }
            }
        }
        return null;
    }

    /**
     *
     */
    public Account searchAccount(long iban) {
        for (Customer index : customerList) {
            List<Account> accList = index.getAccounts();
            for (Account pointer : accList) {
                if (pointer.getAccountNumber() == iban) {
                    return pointer;
                }
            }
        }
        return null;
    }


    // Comparator

    /**
     *
     */
    private final static Comparator<Customer> byId = new Comparator<Customer>() {
        @Override
        public int compare(Customer first, Customer second) {
            return first.getCustomerId() > second.getCustomerId() ? -1 : first.getCustomerId() < second.getCustomerId() ? +1 : 0;
        }
    };


    // Singleton constructor

    /**
     * Anwendung des singleton Muster, um zu gewährleiten
     * das es nur eine Instanz dieses Objektes gibt.
     */
    private Bank() {
        this.name = "Alteingesessene Berliner Bank";
        this.identifierCode = "DEUT DEDB 110";
        this.address1 = "Breite Straße";
        this.address2 = "33-34";
        this.zipcode = 10435;
        this.bankCode = 10070848;
    }

    /**
     * Statische erzeugung der Bank Instanz.
     */
    private static Bank ourInstance = new Bank();

    /**
     * Die statische Methode gibt die Referrenz
     * auf die singleton Instanz zurueck.
     *
     * @return Die Referrenz auf die Bank Instanz.
     */
    public static Bank getInstance() {
        return ourInstance;
    }


}
