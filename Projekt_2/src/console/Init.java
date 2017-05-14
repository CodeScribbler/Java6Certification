package console;

import model.*;
import model.Transaction.TransactionType;
import java.util.Formatter;
import java.util.List;
import java.awt.Frame;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Init {

    public static void main(String[] args) {

        Output.showMainMenu(Bank.getInstance());

        System.exit(0);
    }
}



final class Output {

    /**
     *
     */
    public static void showMainMenu(Bank bank) {
        System.out.println("\n Alteingesessene Berliner Bank - Kontoverwaltung\n");
        byte choice;
        do {
            printMenu(mainMenu);

            choice = Utility.readByte("\n Auswahl: ");


            switch(choice) {
                case 1: {
                    Input.createPrivateCustomer(bank);
                    break;
                }
                case 2: {
                    Input.createBuisnessCustomer(bank);
                    break;
                }
                case 3: {
                    Input.createAccount(bank);
                    break;
                }
                case 4: {
                    Input.search(bank, "byID");
                    break;
                }
                case 5: {
                    Input.search(bank, "byName");
                    break;
                }
                case 6: {
                    long iban = Utility.readLong("Eingabe IBAN: ");
                    if (bank.searchAccount(iban) != null)
                        System.out.println(bank.searchAccount(iban).toString());
                    else
                        System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
                    break;
                }
                case 7: {
                    printPrivateCustomer(bank.getSortedCustomerList(false));
                    printBuisnessCustomer(bank.getSortedCustomerList(false));
                    break;
                }
                case 8: {
                    printPrivateCustomer(bank.getSortedCustomerList(true));
                    printBuisnessCustomer(bank.getSortedCustomerList(true));
                    break;
                }
                case 9: {
                    if(bank.getAllAccounts() != null)
                        Output.printCustomerAccounts(bank.getAllAccounts());
                    else
                        System.out.println("\n\n Es existieren aktuell keine Konten zur Ausgabe!\n\n");
                    break;
                }
                case 10: {
                    Input.createTransaction(bank, "Geld einzahlen",  Transaction.TransactionType.DESPOSIT);
                    break;

                }
                case 11: {
                    Input.createTransaction(bank, "Geld auszahlen", Transaction.TransactionType.DISBURSEMENT);
                    break;

                }
                case 12: {
                    Output.printTransaction(bank, "ASC");
                    break;

                }
                case 13: {
                    Output.printTransaction(bank, "DSC");
                    break;

                }
                case 14: {

                    break;

                }
            }
        } while(choice != 15);

    }


    /**
     *
     */
    private static final String[] mainMenu = {
            " (01) Privatkunde anlegen", " (02) Firmenkunde anlegen", " (03) Konto anlegen und Kundennummer zuordnen",
            " (04) Kunde mit Konten anzeigen (Auswahl durch Kundennummer)", " (05) Kunde mit Konten anzeigen (Auswahl durch Name)",
            " (06) Konto anzeigen (Auswahl durch IBAN) ", " (07) Alle Kunden unsortiert anzeigen", " (08) Alle Kunden sortiert nach aufsteigender Kundenummer anzeigen",
            " (09) Alle Konten unsortiert anzeigen", " (10) Geld auf Konto einzahlen", " (11) Geld vom Konto abheben", " (12) Transaktionsliste absteigend sortiert nach Zeitstempel anzeige",
            " (13) Transaktionsliste aufsteigend sortiert nach Zeitstempel speichern", " (14) Transaktionsliste einlesen", " (15) Beenden"
    };


    /**
     *
     */
    private static void printMenu(String[] options) {
        for (String option : options)
            System.out.println(option);
    }


    /**
     *
     */
    private static void printCustomerAccounts(List<Account> accountList) {
        for (Account index : accountList) {
            System.out.println(index.toString());
        }
    }


    /**
     *
     */
    protected static void printBuisnessCustomer(List<Customer> cList) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (Customer index : cList) {
            if (index instanceof BusinessCustomer)
                formatter.format("%3d %11s %17s %21s %n", index.getCustomerId(),
                        ((BusinessCustomer) index).getCompanyName(),
                        ((BusinessCustomer) index).getContact().getFirstName(),
                        ((BusinessCustomer) index).getContact().getFirstName());
        }
        System.out.printf("Übersicht Firmenkunden:%n| %1s | %10s | %14s |%n", "ID", "Firmenname", "Ansprechpartner Vor- Nachname");
        System.out.println(sb);
    }


    /**
     *
     */
    protected static void printPrivateCustomer(List<Customer> cList) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (Customer index : cList) {
            if (index instanceof PrivateCustomer)
                formatter.format("%3d %11s %17s %n", index.getCustomerId(), ((PrivateCustomer) index).getFirstName(), ((PrivateCustomer) index).getLastname());
        }
        System.out.printf("Übersicht Privatkunden:%n| %1s | %10s | %14s |%n", "ID", "Vorname", "Nachname");
        System.out.println(sb);
    }


    /**
     *
     */
    private static void printTransaction(Bank bank, String option) {
        List<Account> accList = new ArrayList<Account>();
        List<Transaction> transList = new ArrayList<Transaction>();

        accList.addAll(bank.getAllAccounts());

        for (Account index : accList) {
            transList.addAll(index.getSortedTransList(option));
        }
        for (Transaction index : transList) {
            System.out.println(index.toString());
        }
    }


    private Output() {}

}



final class Input {

    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[d][e]$", 2);

    /**
     *
     * @param bank
     * @param option
     */
    public static void search(Bank bank, String option) {
        ArrayList<Account> list = new ArrayList<Account>();

        System.out.println("\n - Kundensuche wird initialisiert - \n");
        if(option.equalsIgnoreCase("byID")) {
            int id;
            do {
                id = Utility.readInt("\n Geben Sie bitte die KdNr ein: ");
                if(id == -1) {
                    System.err.println(" Ungültige Eingabe!");
                }
            } while(id == -1);

            list.addAll(bank.searchCustomer(id, null));
        } else {
            String name;
            do {
                name = Utility.readString("\n Geben Sie bitte den Namen ein: ");
            } while(name == null);

            list.addAll(bank.searchCustomer(-1, name));
        }

        if(list.size() > 0) {
            for (Object index : list) {
                System.out.println(index.toString());
            }
        } else {
            System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
        }

    }

    /**
     *
     * @param prompt
     * @return
     */
    private static String validateEmail(String prompt) {
        String email = Utility.readString(prompt);
        Matcher matcher = VALID_EMAIL.matcher(email);
        return matcher.find()?email:null;
    }

    /**
     *
     * @param bank
     */
    public static void createBuisnessCustomer(Bank bank) {
        System.out.println("\n - Buisness Kundenanlegung wird initialisiert - \n");

        String companyName;
        do {
            companyName = Utility.readString("\n Eingabe Firmenname: ");
        } while(!checkInput());

        String contactFirstname;
        do {
            contactFirstname = Utility.readString("\n Eingabe Ansprechpartner-Vorname: ");
        } while(!checkInput());

        String contactLastname;
        do {
            contactLastname = Utility.readString("\n Eingabe Ansprechpartner-Nachname: ");
        } while(!checkInput());

        String contactPhoneNumber;
        do {
            contactPhoneNumber = Utility.readString("\n Eingabe Telefonnummer: ");
        } while(!checkInput());

        String address;
        do {
            address = Utility.readString("\n Eingabe Adresse: ");
        } while(!checkInput());

        String phoneNumber;
        do {
            phoneNumber = Utility.readString("\n Geben Sie bitte die Telefonnummer ein: ");
        } while(!checkInput());

        String email;
        do {
            email = validateEmail("\n Eingabe E-Mail Adresse: ");
            if(email == null) {
                System.out.println(" Ungültige E-Mail-Adresse!\n");
            }
        } while(email == null || !checkInput());

        if(bank.addCustomer(new BusinessCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.BUSINESSCUSTOMER, email, companyName, new Counterpart(contactFirstname, contactLastname, contactPhoneNumber)))) {
            System.out.println("\n\n Der Firmenkunde wurde erfolgreich angelegt!\n\n");
        } else {
            System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
        }

    }

    /**
     *
     * @param bank
     */
    public static void createPrivateCustomer(Bank bank) {
        Date birthdate = null;
        System.out.println("\n - Private Kundenanlegung wird initialisiert - \n");

        String firstname;
        do {
            firstname = Utility.readString("\n Eingabe Vorname: ");
        } while(!checkInput());

        String lastname;
        do {
            lastname = Utility.readString("\n Eingabe Nachname: ");
        } while(!checkInput());

        String address;
        do {
            address = Utility.readString("\n Eingabe Adresse: ");
        } while(!checkInput());

        String phoneNumber;
        do {
            phoneNumber = Utility.readString("\n Eingabe Telefonnummer: ");
        } while(!checkInput());

        String email;
        do {
            email = validateEmail("\n Eingabe E-Mail Adresse: ");
            if(email == null) {
                System.out.println(" Ungültige E-Mail Adresse!\n");
            }
        } while(email == null || !checkInput());

        do {
            try {
                birthdate = Utility.readDate("\n Eingabe Geburtsdatum, Formatvorgabe dd.mm.yyyy: ");
            } catch (ParseException var8) {
                System.err.println(var8.getMessage());
            }
        } while(birthdate == null || !checkInput());

        if(bank.addCustomer(new PrivateCustomer(Customer.ID++, address, phoneNumber, CustomerTyp.PRIVATECUSTOMER, email, firstname, lastname, birthdate))) {
            System.out.println("\n\n Der Privatkunde wurde erfolgreich angelegt!\n\n");
        } else {
            System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
        }

    }

    /**
     *
     * @param bank
     */
    public static void createAccount(Bank bank) {
        System.out.println("\n - Kontoanlegung wird initialisiert - \n");

        double accountBalance;
        do {
            accountBalance = Utility.readDouble(" Geben Sie bitte den Kontostand ein: ");
        } while(!checkInput());

        Account acc = new Account(Account.ledgerNumber++, accountBalance);
        Output.printPrivateCustomer(bank.getSortedCustomerList(false));
        Output.printBuisnessCustomer(bank.getSortedCustomerList(false));

        int choice = Utility.readInt("\n Zugehöriges Konto, Eingabe Kundennr: ");

        if(bank.setAccount(choice, acc)) {
            System.out.println("\n\n Das Konto wurde erfolgreich angelegt und zugeordnet!\n\n");
        } else {
            System.out.println("\n\n Die Kontoanlegung wurde vom Benutzer abgebrochen!\n\n");
        }
    }

    /**
     *
     * @param bank
     * @param title
     * @param transType
     */
    public static void createTransaction(Bank bank, String title, TransactionType transType) {
        System.out.println("\n ----- " + title + " ----- \n\n");
        long iban = 0L;

        do {
            try {
                if((iban = Utility.readLong("\n Eingabe IBAN: ")) == -1L) {
                    throw new WrongInputException("Fehlerhafte IBAN, die Eingabe wird neu gestartet!");
                }
            } catch (WrongInputException var9) {
                JOptionPane.showMessageDialog(new Frame(), var9.getMessage(), "Benutzereingabe Eingabe", 0);
            }
        } while(iban == -1L);

        Account account = bank.searchAccount(iban);

        if(account != null) {
            double amount;
            do {
                amount = Utility.readDouble(" Eingabe Betrag: ");
                if(transType == TransactionType.DISBURSEMENT && account.getAccountBalance() - amount < 0.0D) {
                    System.out.println(" Das Konto ist nicht ausreichend gedeckt!\n");
                    amount = 0.0D;
                }
            } while(amount == 0.0D && !checkInput());

            String description;
            do {
                description = Utility.readString(" Eingabe Bescheibung: ");
            } while(!checkInput());

            if (account.addTransaction(new Transaction(new Date(), transType, description, amount))) {
                System.out.println(" Die Transanktion wurde erfogrich ausgeführt!");
                return;
            }

        }
        System.out.println(" Das Konto: " + iban + " existiert nicht!");
    }

    /**
     *
     * @return
     */
    public static boolean checkInput() {
        String input = Utility.readString(" Bestätigung der Eingabe mit Ja oder Nein: ");
        return input != null && input.equalsIgnoreCase("j") || input != null && input.equalsIgnoreCase("ja");
    }

    private Input() {
    }
}
