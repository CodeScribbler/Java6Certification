package io;

import util.IOTools;
import model.Person;

public class Input {

    private Input() {}

    public static Person createPerson() {

        String tmpStr;

        String name;
        boolean geschlecht;
        int groesse;
        float gewicht;

        System.out.println("----- Start reading the personal data -----\n");
        do {
            System.out.print("\nInput gender: male = M   -   female = W: ");
            tmpStr = IOTools.readLine();
        } while (!(tmpStr.equalsIgnoreCase("M") || tmpStr.equalsIgnoreCase("W")));
        geschlecht = tmpStr.equalsIgnoreCase("M");

        do {
            System.out.print("\nInput name:");
            name = IOTools.readLine();
        } while (name.isEmpty());

        do {
            System.out.print("\nInput height in cm: ");
            groesse = IOTools.readInt();
        } while (groesse == 0);

        do {
            System.out.print("\nInput weight: ");
            gewicht = IOTools.readFloat();
        } while (gewicht == 0);

        System.out.println("----- Read in the personal data completed -----\n\n");

        return new Person(name, geschlecht, groesse, gewicht);
    }

}
