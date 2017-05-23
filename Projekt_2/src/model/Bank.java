package model;

import java.io.*;
import java.util.*;
import model.Account.Transaction;


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

    /**
     *
     */
    private int bankCode;


    public String getName() {
        return name;
    }

    public String getIdentifierCode() {
        return identifierCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public short getZipcode() {
        return zipcode;
    }

    public int getBankCode() {
        return bankCode;
    }


    // Field with initializer and methods

    /**
     *
     */
    private List<Customer> customerList = new ArrayList<Customer>();

    {
        customerList.add(new PrivateCustomer("MusterStraße 1", "0221-15555", CustomerTyp.PRIVATECUSTOMER, "example1@whatever.com", "Max", "Mustermann", "04.06.1985"));
        customerList.add(new PrivateCustomer("MusterStraße 2", "0221-25555", CustomerTyp.PRIVATECUSTOMER, "example2@whatever.com", "Diana", "Musterfrau", "08.01.1977"));
        customerList.add(new PrivateCustomer("MusterStraße 3", "0221-35555", CustomerTyp.PRIVATECUSTOMER, "example3@whatever.com", "Reiner", "Mustermann", "01.05.1989"));
        customerList.add(new PrivateCustomer("MusterStraße 4", "0221-45555", CustomerTyp.PRIVATECUSTOMER, "example4@whatever.com", "Sabrina", "Musterfrau", "24.12.1991"));
        customerList.add(new PrivateCustomer("MusterStraße 5", "0221-55555", CustomerTyp.PRIVATECUSTOMER, "example5@whatever.com", "Dirk", "Mustermann", "11.11.1965"));

        customerList.add(new BusinessCustomer("MusterStraße 6", "0221-65555", CustomerTyp.BUSINESSCUSTOMER, "example6@whatever.com", "Consulting aAa", new Counterpart("Dave", "Nobody", "0221-115555")));
        customerList.add(new BusinessCustomer("MusterStraße 7", "0221-75555", CustomerTyp.BUSINESSCUSTOMER, "example7@whatever.com", "Consulting bBb", new Counterpart("Chris", "Nobody", "0221-125555")));
        customerList.add(new BusinessCustomer("MusterStraße 8", "0221-85555", CustomerTyp.BUSINESSCUSTOMER, "example8@whatever.com", "Consulting cCc", new Counterpart("Darrel", "Nobody", "0221-135555")));
        customerList.add(new BusinessCustomer("MusterStraße 9", "0221-95555", CustomerTyp.BUSINESSCUSTOMER, "example9@whatever.com", "Consulting dDd", new Counterpart("Jack", "Nobody", "0221-145555")));
        customerList.add(new BusinessCustomer("MusterStraße 10", "0221-105555", CustomerTyp.BUSINESSCUSTOMER, "example10@whatever.com", "Consulting eEe", new Counterpart("Michael", "Nobody", "0221-155555")));

        List<Account> accountList = new ArrayList<Account>();
        for (Customer index : customerList) {
            index.addAccount(new Account(IBANGenerator.getInstance().getNumber(), 5000));
            accountList.addAll(index.getAccounts());
        }
        for (Account index :accountList) {
            index.addTransaction(index.new Transaction(IBANGenerator.getInstance().getNumber(), Utility.getDate(null), TransactionType.DESPOSIT, 5000, "Urlaubsgeld Juni"));
            index.addTransaction(index.new Transaction(IBANGenerator.getInstance().getNumber(), Utility.getDate(null), TransactionType.DISBURSEMENT, 700, "Party July"));
            index.addTransaction(index.new Transaction(IBANGenerator.getInstance().getNumber(), Utility.getDate(null), TransactionType.DESPOSIT, 3800, "Gehaltseingang Oktober"));
            index.addTransaction(index.new Transaction(IBANGenerator.getInstance().getNumber(), Utility.getDate(null), TransactionType.DISBURSEMENT, 800, "Miete Oktober"));
            index.addTransaction(index.new Transaction(IBANGenerator.getInstance().getNumber(), Utility.getDate(null), TransactionType.DISBURSEMENT, 200, "Amazon"));
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
    public boolean setAccount(String id, Account acc) {
        for (Customer index : customerList) {
            if (index instanceof PrivateCustomer) {
                if (index.getCustomerId().equals(id)) return index.addAccount(acc);
            }
            if (index instanceof BusinessCustomer) {
                if (index.getCustomerId().equals(id)) return index.addAccount(acc);
            }
        }
        return false;
    }

    /**
     *
     */
    public List<Account> searchCustomer(String id, String name) {
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
                if (INDEX.getCustomerId().equals(id)) {
                    System.out.println("\n " + ((PrivateCustomer) INDEX).getFirstName() + " - " + ((PrivateCustomer) INDEX).getLastname());
                    return INDEX.getAccounts();
                }
            }
            if (INDEX instanceof BusinessCustomer) {
                if (INDEX.getCustomerId().equals(id)) {
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
    public Account searchAccount(String iban) {
        for (Customer index : customerList) {
            List<Account> accList = index.getAccounts();
            for (Account pointer : accList) {
                if (pointer.getAccountNumber().equals(iban)) {
                    return pointer;
                }
            }
        }
        return null;
    }


    public boolean createCsvFile(String path) {
        File file = new File(path);
        BufferedWriter fWriter = null;

        List<Account> accountList = new ArrayList<Account>(getAllAccounts());
        List<String> ibanList = new ArrayList<String>();
        List<Transaction> transList = new ArrayList<Transaction>();

        for (Account index : accountList) {
            ibanList.add(index.getAccountNumber());
            transList.addAll(index.getSortedTransList("ASC"));
        }

        // File file = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\TRANSAKTIONEN.csv");

        try {
            fWriter = new BufferedWriter(new FileWriter(file));

            String fileHeader = "IBAN, Zeitstempel, Transaktionsart, Beschreibungstext, Betrag";
            fWriter.append(fileHeader);
            fWriter.append("\n");

            for (String iban : ibanList) {
                fWriter.append(String.valueOf(iban));
                for (Transaction index : transList) {
                    fWriter.append(String.valueOf(index.getTimestamp()));
                    fWriter.append(";");
                    if (index.getTransType() == TransactionType.DESPOSIT)
                        fWriter.append("Einzahlung;");
                    if (index.getTransType() == TransactionType.DISBURSEMENT)
                        fWriter.append("Auszahlung;");
                    fWriter.append(index.getDescription());
                    fWriter.append(";");
                    fWriter.append(String.valueOf(index.getAmount()));
                    fWriter.append("\n");
                    break;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            ExceptionDialog.showDialog(e, null);
        } catch (IOException e) {
            ExceptionDialog.showDialog(e, null);
        } finally {
            if (fWriter != null) try {
                fWriter.close();
            } catch (IOException e) {
                ExceptionDialog.showDialog(e, null);
            }
        }
        return false;
    }


    public boolean readCsvFile(Bank bank, String path) {
        File file = new File(path);

        if (file.exists()) {
            List<Account> accountList = new ArrayList<Account>(bank.getAllAccounts());
            int IBAN = 0;
            int TIMESTAMP = 1;
            int TRANSACTIONTYPE = 2;
            int AMOUNT = 3;
            int DESCRIPTION = 4;

            String line;
            BufferedReader fReader;

            try {
                fReader = new BufferedReader(new FileReader(file));

                while ((line = fReader.readLine()) != null) {
                    String[] tokens = line.split(";");

                    if (tokens.length > 0) {
                        for (Account index : accountList) {
                            if (String.valueOf(index.getAccountNumber()).equals(tokens[IBAN])) {

                                if (Utility.checkDateFormat(tokens[TIMESTAMP], true)) {
                                    Account acc = new Account();
                                    Transaction transaction = acc.new Transaction(tokens[IBAN], Utility.getDate(tokens[TIMESTAMP]),
                                            ((tokens[TRANSACTIONTYPE]).equalsIgnoreCase("Einzahlen") ? TransactionType.DESPOSIT : TransactionType.DISBURSEMENT),
                                            Double.parseDouble(tokens[AMOUNT]),
                                            tokens[DESCRIPTION]);

                                    index.addTransaction(transaction);
                                }
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                ExceptionDialog.showDialog(e, null);
            } catch (IOException e) {
                ExceptionDialog.showDialog(e, null);
            }
        } return false;
    }


    // Comparator

    /**
     *
     */
    private final static Comparator<Customer> byId = new Comparator<Customer>() {
        @Override
        public int compare(Customer first, Customer second) {
            return first.getCustomerId().compareTo(second.getCustomerId());
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
    private static Bank bankInstance = new Bank();

    /**
     * Die statische Methode gibt die Referrenz
     * auf die singleton Instanz zurueck.
     *
     * @return Die Referrenz auf die Bank Instanz.
     */
    public static Bank getInstance() {
        return bankInstance;
    }


}