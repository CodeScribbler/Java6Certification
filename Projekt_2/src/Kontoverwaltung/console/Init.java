package Kontoverwaltung.console;

import Kontoverwaltung.model.Bank;

public class Init {

    public static void main(String[] args) {

        Output.showMainMenu(Bank.getInstance());

        System.exit(0);
    }

}
