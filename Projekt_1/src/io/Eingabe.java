package io;

import util.IOTools;
import model.Person;

public class Eingabe {

    private Eingabe() {}

    public static Person liesPerson() {

        String tmpStr;

        String name;
        boolean geschlecht;
        int groesse;
        float gewicht;

        System.out.println("----- Starte einlesen der Personendaten -----\n");
        do {
            System.out.print("\nEingabe Geschlecht: Männlich = M   -   Weiblich = W: ");
            tmpStr = IOTools.readLine();
        } while (!(tmpStr.equalsIgnoreCase("M") || tmpStr.equalsIgnoreCase("W")));
        geschlecht = tmpStr.equalsIgnoreCase("M");

        do {
            System.out.print("\nEingabe Name:");
            name = IOTools.readLine();
        } while (name.isEmpty());

        do {
            System.out.print("\nEingabe Größe in cm: ");
            groesse = IOTools.readInt();
        } while (groesse == 0);

        do {
            System.out.print("\nEingabe Gewicht: ");
            gewicht = IOTools.readFloat();
        } while (gewicht == 0);

        System.out.println("----- Einlesen der Personendaten abgeschlossen -----\n\n");

        return new Person(name, geschlecht, groesse, gewicht);
    }

}
