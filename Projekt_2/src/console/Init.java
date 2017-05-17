package console;

import model.*;
import model.Account.Transaction;

import java.io.File;
import java.util.*;
import java.awt.Frame;
import java.text.ParseException;
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


            switch (choice) {
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
                    if (bank.getAllAccounts() != null)
                        Output.printCustomerAccounts(bank.getAllAccounts());
                    else
                        System.out.println("\n\n Es existieren aktuell keine Konten zur Ausgabe!\n\n");
                    break;
                }
                case 10: {
                    Input.createTransaction(bank, "Geld einzahlen", TransactionType.DESPOSIT);
                    break;

                }
                case 11: {
                    Input.createTransaction(bank, "Geld auszahlen", TransactionType.DISBURSEMENT);
                    break;

                }
                case 12: {
                    Output.printTransaction(bank, "ASC");
                    break;

                }
                case 13: {
                    if (bank.createCsvFile(Input.readCsvInfo(bank, Input.transMenuSave)))
                        System.out.println("\n Die CSV-Datei wurde erfolgreich erstellt!\n");
                    else
                        System.out.println("\n Das angegebene Verzeichnis existiert nicht!\n");
                    break;

                }
                case 14: {
                    bank.readCsvFile(bank, Input.readCsvInfo(bank, Input.transMenuLoad));
                    break;

                }
            }
        } while (choice != 15);

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
    protected static void printMenu(String[] options) {
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
                formatter.format("%18s %17s %19s %16s %n", index.getCustomerId(), ((BusinessCustomer) index).getCompanyName(), ((BusinessCustomer) index).getContact().getFirstName(), ((BusinessCustomer) index).getContact().getLastname());
        }
        System.out.printf("\n Übersicht Firmenkunden:%n%n %8s %5s %4s %14s %5s %5s %3s %n", "|", "ID", "|", "Firmenname", "|", "Ansprechpartner Vor- Nachname", "|");
        Output.printSeparator(68, 67);
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
                formatter.format("%18s %11s %16s %n", index.getCustomerId(), ((PrivateCustomer) index).getFirstName(), ((PrivateCustomer) index).getLastname());
        }
        System.out.printf("\n Übersicht Privatkunden:%n%n %8s %5s %4s %10s %3s %10s %3s %n", "|", "ID", "|", "Vorname", "|", "Nachname", "|");
        Output.printSeparator(44, 43);
        System.out.println(sb);
    }


    /**
     *
     */
    private static void printTransaction(Bank bank, String option) {
        List<Account> accList = new ArrayList<Account>();
        List <Transaction> transList = new ArrayList<Transaction>();

        accList.addAll(bank.getAllAccounts());

        if (accList.isEmpty()) {
            System.out.println("\n Aktuell sind keine Transaktionen vorhanden!\n");
            return;
        }

        for (Account index : accList) {
            transList.addAll(index.getSortedTransList(option));
        }

        for (Object index : transList) {
            System.out.println(index.toString());
        }
        System.out.println("\n");
    }


    private static void printSeparator(int count, int eof) {
        for (int i = 0; i < count; i++) {
            if (i > 1)
                System.out.print("-");
            else
                System.out.print("\t");
            if (i == eof)
                System.out.print("\n");}
    }


    private Output() {
    }

}


final class Input {

    protected static final String[] transMenuSave = {"\n\n ----- Transaktionen speichern ----- \n\n", "(1) Speichern unter C:\\", "(2) Speichern unter Desktop", "(3) Speicherort selbst auswählen", "(4) Abbrechen"};

    protected static final String[] transMenuLoad = {"\n\n ----- Transaktionen einlesen ----- \n\n", "(1) Einlesen unter C:\\", "(2) Einlesen unter Desktop", "(3) Verzeichnis selbst auswählen", "(4) Abbrechen"};

    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[d][e]$", Pattern.CASE_INSENSITIVE);


    /**
     * @param bank
     * @param option
     */
    protected static void search(Bank bank, String option) {
        ArrayList<Account> list = new ArrayList<Account>();

        System.out.println("\n - Kundensuche wird initialisiert - \n");
        if (option.equalsIgnoreCase("byID")) {
            String id;
            do {
                id = Utility.readString("\n Geben Sie bitte die KdNr ein: ");
                if (id == null) {
                    System.err.println(" Ungültige Eingabe!");
                }
            } while (id == null);

            list.addAll(bank.searchCustomer(id, null));
        } else {
            String name;
            do {
                name = Utility.readString("\n Geben Sie bitte den Namen ein: ");
            } while (name == null);

            list.addAll(bank.searchCustomer(null, name));
        }

        if (list.size() > 0) {
            for (Object index : list) {
                System.out.println(index.toString());
            }
        } else {
            System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
        }

    }

    /**
     * @param prompt
     * @return
     */
    protected static String validateEmail(String prompt) {
        String email = Utility.readString(prompt);
        Matcher matcher = VALID_EMAIL.matcher(email);
        return matcher.find() ? email : null;
    }

    /**
     * @param bank
     */
    protected static void createBuisnessCustomer(Bank bank) {
        System.out.println("\n - Buisness Kundenanlegung wird initialisiert - \n");

        String companyName;
        do {
            companyName = Utility.readString("\n Eingabe Firmenname: ");
        } while (!checkInput());

        String contactFirstname;
        do {
            contactFirstname = Utility.readString("\n Eingabe Ansprechpartner-Vorname: ");
        } while (!checkInput());

        String contactLastname;
        do {
            contactLastname = Utility.readString("\n Eingabe Ansprechpartner-Nachname: ");
        } while (!checkInput());

        String contactPhoneNumber;
        do {
            contactPhoneNumber = Utility.readString("\n Eingabe Telefonnummer: ");
        } while (!checkInput());

        String address;
        do {
            address = Utility.readString("\n Eingabe Adresse: ");
        } while (!checkInput());

        String phoneNumber;
        do {
            phoneNumber = Utility.readString("\n Geben Sie bitte die Telefonnummer ein: ");
        } while (!checkInput());

        String email;
        do {
            email = validateEmail("\n Eingabe E-Mail Adresse: ");
            if (email == null) {
                System.out.println(" Ungültige E-Mail-Adresse!\n");
            }
        } while (email == null || !checkInput());

        if (bank.addCustomer(new BusinessCustomer(address, phoneNumber, CustomerTyp.BUSINESSCUSTOMER, email, companyName, new Counterpart(contactFirstname, contactLastname, contactPhoneNumber)))) {
            System.out.println("\n\n Der Firmenkunde wurde erfolgreich angelegt!\n\n");
        } else {
            System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
        }

    }

    /**
     * @param bank
     */
    protected static void createPrivateCustomer(Bank bank) {
        Date birthdate = null;
        System.out.println("\n - Private Kundenanlegung wird initialisiert - \n");

        String firstname;
        do {
            firstname = Utility.readString("\n Eingabe Vorname: ");
        } while (!checkInput());

        String lastname;
        do {
            lastname = Utility.readString("\n Eingabe Nachname: ");
        } while (!checkInput());

        String address;
        do {
            address = Utility.readString("\n Eingabe Adresse: ");
        } while (!checkInput());

        String phoneNumber;
        do {
            phoneNumber = Utility.readString("\n Eingabe Telefonnummer: ");
        } while (!checkInput());

        String email;
        do {
            email = validateEmail("\n Eingabe E-Mail Adresse: ");
            if (email == null) {
                System.out.println(" Ungültige E-Mail Adresse!\n");
            }
        } while (email == null || !checkInput());

        do {
            try {
                birthdate = Utility.readDate("\n Eingabe Geburtsdatum, Formatvorgabe dd.mm.yyyy: ");
            } catch (ParseException var8) {
                System.err.println(var8.getMessage());
            }
        } while (birthdate == null || !checkInput());

        if (bank.addCustomer(new PrivateCustomer(address, phoneNumber, CustomerTyp.PRIVATECUSTOMER, email, firstname, lastname, birthdate))) {
            System.out.println("\n\n Der Privatkunde wurde erfolgreich angelegt!\n\n");
        } else {
            System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
        }

    }

    /**
     * @param bank
     */
    protected static void createAccount(Bank bank) {
        System.out.println("\n - Kontoanlegung wird initialisiert - \n");

        double accountBalance;
        do {
            accountBalance = Utility.readDouble(" Geben Sie bitte den Kontostand ein: ");
        } while (!checkInput());

        Account acc = new Account(Account.IBAN++, accountBalance);
        Output.printPrivateCustomer(bank.getSortedCustomerList(false));
        Output.printBuisnessCustomer(bank.getSortedCustomerList(false));

        String choice = Utility.readString("\n Zugehöriges Konto, Eingabe Kundennr: ");

        if (bank.setAccount(choice, acc)) {
            System.out.println("\n\n Das Konto wurde erfolgreich angelegt und zugeordnet!\n\n");
        } else {
            System.out.println("\n\n Die Kontoanlegung wurde vom Benutzer abgebrochen!\n\n");
        }
    }

    /**
     * @param bank
     * @param title
     * @param transType
     */
    protected static void createTransaction(Bank bank, String title, TransactionType transType) {
        System.out.println("\n ----- " + title + " ----- \n");
        long iban = 0L;

        do {
            try {
                if ((iban = Utility.readLong(" Eingabe IBAN: ")) == -1L) {
                    throw new WrongInputException(" Fehlerhafte IBAN, die Eingabe wird neu gestartet!");
                }
            } catch (WrongInputException var9) {
                JOptionPane.showMessageDialog(new Frame(), var9.getMessage(), "Benutzereingabe Eingabe", 0);
            }
        } while (iban == -1L);

        Account account = bank.searchAccount(iban);

        if (account != null) {
            double amount;
            do {
                amount = Utility.readDouble(" Eingabe Betrag: ");
                if (transType == TransactionType.DISBURSEMENT && account.getAccountBalance() - amount < 0.0D) {
                    System.out.println(" Das Konto ist nicht ausreichend gedeckt!\n");
                    amount = 0.0D;
                }
            } while (amount == 0.0D && !checkInput());

            String description;
            do {
                description = Utility.readString(" Eingabe Bescheibung: ");
            } while (!checkInput());

            if (account.addTransaction(new Account().new Transaction(Utility.getDate(null), transType, amount, description))) {
                System.out.println(" Die Transanktion wurde erfogrich ausgeführt!\n\n");
                return;
            }

        }
        System.out.println(" Das Konto: " + iban + " existiert nicht!\n\n");
    }

    /**
     * @return
     */
    protected static boolean checkInput() {
        String input = Utility.readString(" Bestätigung der Eingabe mit Ja oder Nein: ");
        return input != null && input.equalsIgnoreCase("j") || input != null && input.equalsIgnoreCase("ja");
    }


    protected static String readCsvInfo(Bank bank, String[] options) {
        String path;
        int chioce;
        List<Account> accountList = new ArrayList<Account>();

        if (options[0].equals("----- Transaktionen speichern -----")) {
            accountList.addAll(bank.getAllAccounts());
            for (Account index : accountList) {
                if (index.getTransListSize() > 0)
                    System.out.println(" Da ist etwas!");


            }
        }

        Output.printMenu(options);

        do {
            chioce = Utility.readInt("Auswahl: ");

            switch (chioce) {
                case 1:
                    return "C:\\Kontoverwaltung_TRANSAKTIONEN.csv";

                case 2:
                    return "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Kontoverwaltung_TRANSAKTIONEN.csv";

                case 3:
                    path = Utility.readString("Eingabe Verzeichnis: ");
                    if (path != null) {
                        File file = new File(path);
                        if (file.exists()) return path;
                    }
                    System.err.println(" Fehlerhafte Benutzereingabe!\n");
                    break;
            }
        } while (chioce != 4);
        return null;
    }


    private Input() {
    }

}
