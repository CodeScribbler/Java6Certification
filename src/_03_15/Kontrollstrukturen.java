package _03_15;

import java.util.Scanner;

public class Kontrollstrukturen {

    private static Scanner input;

    public static void main(String[] args) {

        byte month;

        input = new Scanner(System.in);


        System.out.println("Geben Sie bitte den aktuellen Monat im Dezimalformat ein (1-12): ");
        month = input.nextByte();


        switch(month) {
            case 1:
                System.out.println("Januar hat 31 Tage!");    break;
            case 2:
                System.out.println("Februar hat 28 Tage!");   break;
            case 3:
                System.out.println("März hat 31 Tage!");      break;
            case 4:
                System.out.println("April hat 30 Tage!");     break;
            case 5:
                System.out.println("Mai hat 31 Tage!");       break;
            case 6:
                System.out.println("Juni hat 30 Tage!");      break;
            case 7:
                System.out.println("Juli hat 31 Tage!");      break;
            case 8:
                System.out.println("August hat 31 Tage!");    break;
            case 9:
                System.out.println("September hat 30 Tage!"); break;
            case 10:
                System.out.println("Oktober hat 31 Tage!");   break;
            case 11:
                System.out.println("November hat 30 Tage!");  break;
            case 12:
                System.out.println("Dezember hat 30 Tage!");  break;
            default:
                System.out.println("Fehlerhafte Eingabe!");

        }



    }

}
