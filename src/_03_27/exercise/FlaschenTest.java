package _03_27.exercise;

import utility.IOTools;

/**
 *
 * In dieser Klasse werden die Klassen MehrwegFlasche und EinwegFlasche getestet.
 *
 */

public class FlaschenTest {

    public static void main(String[] args) {
        Flasche fl; //erzeugt Referenzvariable vom Typ Flasche

        boolean istMehrweg = IOTools.readBoolean("Falls eine MehrwegFlasche erzeugt werden soll, bitte true eingeben, " +
                "ansonsten false eingeben: ");

        //abhängig vom eingegebenen boolean istMehrweg, erzeuge Objekt

        if(istMehrweg){
            System.out.println("Es wird ein MehrwegFlasche erzeugt.");

            fl = new MehrwegFlasche("Spezi", 600, 25);
        }
        else{
            System.out.println("Es wird eine Einwegflasche erzeugt.");

            fl = new EinwegFlasche("Ice Tea", 1000, true);
        }
        //gibt die Rückgabe der jeweiligen toString - Methode aus
        String ausgabe = fl.toString();
        System.out.println(ausgabe);

        //von welchen Klassen ist fl Instanz ?

        //IHR Code Hier
        System.out.println("\n " + fl.getClass().getName());
    }

}