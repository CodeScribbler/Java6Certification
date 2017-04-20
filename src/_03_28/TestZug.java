package _03_28;

import utility.Terminal;

public class TestZug {

    public static void main(String[] args) {

        System.out.println("------- Bahnhof Köln -------");
        System.out.println("1: Zugführer....");


        int enter = Terminal.askInt("Eingabe: ");

        do {

            switch (enter) {

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
            }

        } while(enter != 0);

        System.out.println("Ende!");

    }

}