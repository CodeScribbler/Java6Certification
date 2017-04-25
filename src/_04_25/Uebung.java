package _04_25;


import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Pattern:
 * 				\d
 * 				\s
 * 				\w
 * 				. bel Zeichen
 * 				^  Zeilenanfang
 * 				$ Zeilenende
 *
 * 				[] Auswahlliste
 * 				[^abc], ^ist hier Negation
 * 				Quantifiers: *, +, ?
 *
 *
 */

/*
 * User wird aufgefordert nach Eingabe von Email Adresse
 * Programm überprüft ob die email Adresse gültig ist, wenn nicht soll user erneut gefragt werden
 *
 * User nach Password gefragt
 * Das Programm überprüft ob das Passsowrt legal ist, wenn nicht soll user erneut gefragt werden
 *
 * Emailadresse:
 *
 * 			benutzername@daomainname.landkennung
 *
 * 		benutzername:
 * 					Eine Kombination aus Zeichen der mindest Länge = 1.
 * 					@ Zeichen darf nicht vorkommen
 * 		Domainname:
 * 					Eine Kombination aus Zeichen der mindest Länge = 1.
 * 					@ Zeichen darf nicht vorkommen
 *
 * 		Landkennung:
 * 					kommt unmittlbar nach letztes .
 * 					Eine Kombination aus buchstaben der mindest Länge 2
 *
 * Passwort:
 * 			-hat mindest Länge 8
 * 			-ist eine Zeichenkombination aus Ziffern, _ und Buchstaben(klein und groß zulässig)
 *
 *
 * Hinweis:
 * 			- Verwende die Methode Pattern.matches(regx, String)
 */

public class Uebung {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int choose;
        String email = "-", password = "-";

        do {

            System.out.println("Set email: 1");
            System.out.println(" Set pass: 2");
            System.out.println("     Exit: 3");

            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            System.out.print("\n\nchoose: ");
            choose = input.nextInt();


            if(choose > 0 && choose <= 3) {

                switch (choose) {

                    case 1:
                        System.out.println("Input email address:" );
                        String val = input.next();
                        if (istEmailAdresseLegal(val)) {
                            System.out.println("Email is valid!");
                            email = val;
                        }
                        else System.out.println("Email is not valid");
                        break;

                    case 2:
                        System.out.println("Input password:" );
                        val = input.next();
                        if (istPasswordLegal(val)) {
                            System.out.println("Password is valid!");
                            password = val;
                        }
                        else System.out.println("Password is not valid!");
                        break;
                }

            }


        }while(choose != 5);

    }

    private static boolean istEmailAdresseLegal(String email) {
        return true;
    }

    private static boolean istPasswordLegal(String password){
        return true;
    }



}
