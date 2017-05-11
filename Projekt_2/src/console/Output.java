package console;

import model.Bank;


public final class Output {

    /**
     *
     */
    public static void showMainMenu(Bank bank) {
        System.out.println("\n Alteingesessene Berliner Bank - Kontoverwaltung\n");
        byte choice;
        do {
            printMenu(mainMenu);

            choice = Input.readByte("\n Eingabe: ");

            switch(choice) {
                case 1: {
                    if(Input.createPrivateCustomer(bank)) System.out.println("\n\n Der Privatkunde wurde erfolgreich angelegt!\n\n");
                    else System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
                    break;
                }
                case 2: {
                    if(Input.createBuisnessCustomer(bank)) System.out.println("\n\n Der Firmenkunde wurde erfolgreich angelegt!\n\n");
                    else System.out.println("\n\n Die Kundenanlegung wurde vom Benutzer abgebrochen!\n\n");
                    break;
                }
                case 3: {
                    if(Input.createAccount(bank)) System.out.println("\n\n Das Konto wurde erfolgreich angelegt und zugeordnet!\n\n");
                    else System.out.println("\n\n Die Kontoanlegung wurde vom Benutzer abgebrochen!\n\n");
                    break;
                }
                case 4: {
                    if (!bank.searchCustomer("byID")) System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
                    break;
                }
                case 5: {
                    if (!bank.searchCustomer("byName")) System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
                    break;
                }
                case 6: {
                    if (!bank.searchAccount()) System.out.println("\n\n Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!\n\n");
                    break;
                }
                case 7: {
                    bank.printPrivateCustomer(bank.getSortedCustomerList(false));
                    bank.printBuisnessCustomer(bank.getSortedCustomerList(false));
                    break;
                }
                case 8: {
                    bank.printPrivateCustomer(bank.getSortedCustomerList(true));
                    bank.printBuisnessCustomer(bank.getSortedCustomerList(true));
                    break;
                }
                case 9: {
                    if(!bank.printAllAccounts()) System.out.println("\n\n Es existieren aktuell keine Konten zur Ausgabe!\n\n");
                    break;
                }
                case 10: {

                    break;

                }
                case 11: {

                    break;

                }
                case 12: {

                    break;

                }
                case 13: {

                    break;

                }
                case 14: {

                    break;

                }
                case 15: {

                    break;

                }
            }
        } while(choice != 10);

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
    public static void printMenu(String[] options) {
        for (String option : options)
            System.out.println(option);
    }

    private Output() {}

}
