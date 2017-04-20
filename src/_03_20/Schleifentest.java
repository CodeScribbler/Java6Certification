package _03_20;

import utility.Terminal;

public class Schleifentest {

    public static void main(String[] args) {

        try {

            int[] arr = Terminal.askIntArray("Eingabe Zahlenreihe: ");
            int wert = Terminal.askInt("\n Eingabe Suchwert: ");

            System.out.println("\n\nErgebnis der For-Schleife:" + sucheFor(arr, wert));
            System.out.println("Ergebnis der While-Schleife:" + sucheWhile(arr, wert));
            System.out.println("Ergebnis der DoWhile-Schleife:" + sucheDoWhile(arr, wert));

            System.out.flush();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static int sucheFor(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    private static int sucheWhile(int[] arr, int value) {
        byte index = 0;

        while(index < arr.length) {
            if(arr[index] == value) {
                return index;
            }
            index++;
        }
        return -1;
    }


    private static int sucheDoWhile(int[] arr, int value) {
        byte index = 0;

        do {
            if(arr[index] == value) {
                return index;
            }
            index++;
        }while(index < arr.length);

        return -1;
    }

}
