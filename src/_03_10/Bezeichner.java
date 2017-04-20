package _03_10;

import java.io.IOException;

public class Bezeichner {

    public static void main(String[] args) throws IOException {

        double gewicht = 0.0;
        double groesse = 0.0;
        double bmi = 0.0;
        int alter = 28;




        System.out.println("Eingabe Gewicht: ");
        gewicht = System.in.read();

        System.out.println("Eingabe Groeße: ");
        groesse = System.in.read();

        bmi = ((gewicht * 703)/(groesse * groesse));

        System.out.print("Du bist %f " + alter + " alt ");
        System.out.println("mit einem BMI von: " + bmi);
    }
}
