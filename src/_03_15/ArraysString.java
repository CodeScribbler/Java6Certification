package _03_15;

import java.util.Scanner;

public class ArraysString {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            int value = 0;
            System.out.println(" Geben Sie bitte die Anzahl der Zahlen ein: ");
            value = input.nextShort();

            int[] field = new int[value];
            field = fillArray(value);

            input.close();

            for(int zahl : field) {
                System.out.println(zahl);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] fillArray(int value)
    {
        int[] anzahl = new int[value];

        for(int i = 0; i < value; i++) {
            System.out.println(" Geben Sie bitte eine Zahl ein: ");
            anzahl[i] = input.nextInt();
        }
        return anzahl;
    }

}
