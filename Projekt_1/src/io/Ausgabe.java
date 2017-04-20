package io;

import model.*;

public class Ausgabe {

    public static String gibAusPerson(Person obj) {
        return "  Person: \n --------- \n Name: " + obj.getName() +
                "\n Geschelcht: " + ((obj.getGeschlecht()) ? "Männlich" : "Weiblich") +
                "\n Körpergröße: " + obj.getKoerpergroesse() + "\n Gewicht: " + obj.getGewicht() + "\n";
    }

    public static String gibAusPersonMitGewichten(Person obj) {
        return gibAusPerson(obj) + "Normalgewicht: " + obj.getNormalgewicht() + "\n Idealgewicht: " + obj.getIdealgewicht() + "\n";
    }

    public static String gibAusPersonMitGewichtenUndBMI(Person obj) {
        return gibAusPerson(obj) + gibAusPersonMitGewichten(obj) + "BMI-Wert: " + obj.getBmiwert();
    }


}
