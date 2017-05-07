package Kontoverwaltung.console;


import Kontoverwaltung.model.Bank;

public final class Output {

    public static void showMainMenu(Bank bank) {
        System.out.println("\n Alteingesessene Berliner Bank - Kontoverwaltung\n");
        byte choice;
        do {
            printMenu(mainMenu);

            choice = Input.readByte("\n Eingabe: ");

            switch(choice) {
                case 1: {
                    if(Input.createCustomer(bank)) System.out.println(" Der Privatkunde wurde erfolgreich angelegt!");
                    else System.out.println(" Die Kundenanlegung wurde vom Benutzer abgebrochen!");
                    break;
                }
                case 2: {
                    if(Input.createCustomer(bank)) System.out.println(" Der Firmenkunde wurde erfolgreich angelegt!");
                    else System.out.println(" Die Kundenanlegung wurde vom Benutzer abgebrochen!");
                    break;
                }
                case 3: {
                    if(Input.createAccount(bank)) System.out.println(" Das Konto wurde erfolgreich angelegt und zugeordnet!");
                    else System.out.println(" Die Kontoanlegung wurde vom Benutzer abgebrochen!");
                    break;
                }
                case 4: {
                    if (!bank.searchCustomer("byID")) System.out.println(" Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!");
                    break;
                }
                case 5: {
                    if (!bank.searchCustomer("byName")) System.out.println(" Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!");
                    break;
                }
                case 6: {
                    if (!bank.searchAccount()) System.out.println(" Die Suchanfrage ist fehlgeschlagen, es gab keine Übereinstimmung!");
                    break;
                }
                case 7: {

                    break;
                }
                case 8: {

                    break;
                }
                case 9: {

                    break;
                }
            }
        } while(choice != 10);
    }


    private static final String[] mainMenu = { " (01) Privatkunde anlegen", " (02) Firmenkunde anlegen", " (03) Konto anlegen und Kundennummer zuordnen",
            " (04) Kunde mit Konten anzeigen (Auswahl durch Kundennummer)", " (05) Kunde mit Konten anzeigen (Auswahl durch Name)",
            " (06) Konto anzeigen (Auswahl durch IBAN) ", " (07) Alle Kunden unsortiert anzeigen", " (08) Alle Kunden sortiert nach aufsteigender Kundenummer anzeigen",
            " (09) Alle Konten unsortiert anzeigen", " (10) Beenden" };


    public static void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++)
            System.out.println(options[i]);
    }


    private Output() {}

}
