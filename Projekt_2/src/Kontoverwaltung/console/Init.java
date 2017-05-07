package Kontoverwaltung.console;

import Kontoverwaltung.model.Bank;

public class Init {

    public static void main(String[] args) {

        Bank obj1 = Bank.getInstance();
        Bank obj2 = Bank.getInstance();

        System.out.println(obj1.equals(obj2));

        Output.showMainMenu(Bank.getInstance());

        System.exit(0);
    }

}
