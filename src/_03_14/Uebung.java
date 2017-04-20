package _03_14;

import java.util.Scanner;

public class Uebung {

    public static void main(String[] args) {
        try {

            Scanner scan = new Scanner(System.in);

            byte   _Alter;
            double _Gewicht;
            double _Groesse;
            double _BMI;
            String _Ergebnis = "";

            System.out.println(" Bitte geben Sie ihr Gewicht ein :");
            _Gewicht = scan.nextDouble();

            System.out.println("\n Bitte geben Sie ihre Größe ein :");
            _Groesse = scan.nextDouble();

            System.out.println("\n Bitte geben Sie ihr Alter ein :");
            _Alter = scan.nextByte();

            scan.close();

            _BMI = _Gewicht / Math.pow((_Groesse /100), 2);

            System.out.println("\n Ihr BMI ist :" +_BMI +"\n");


            if(_Alter <= 25)
            {
                if(_BMI >= 19 || _BMI <= 24)
                    _Ergebnis = "Optimal";
                else if(_BMI < 19)
                    _Ergebnis = "Untergewicht";
                else
                    _Ergebnis = "Übergewicht";
            }

            if(_Alter <= 64)
            {
                if(_BMI >= 22 || _BMI <= 27)
                    _Ergebnis = "Optimal";
                else if(_BMI < 22)
                    _Ergebnis = "Untergewicht";
                else
                    _Ergebnis = "Übergewicht";
            }

            if(_Alter >= 65)
            {
                if(_BMI >= 27 || _BMI <= 29)
                    _Ergebnis = "Optimal";
                else if(_BMI <= 27)
                    _Ergebnis = "Untergewicht";
                else
                    _Ergebnis = "Übergewicht";
            }

            System.out.println("Dies entspricht '" + _Ergebnis + "'");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);

    }
}

