package _03_15;

import java.util.Scanner;

public class UlamZahlenfolge {

    public static void main(String[] args) {

        try {

            Scanner input = new Scanner(System.in);

            int value = 0;
            System.out.println(" Geben Sie bitte eine Zahl ein: ");
            value = input.nextShort();
            input.close();

            ulam(value);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private static void ulam(int value)
    {
        try {

            while(true)
            {
                System.out.println(value);

                if(value % 2 == 0) {
                    value /=2;
                }
                else {
                    value *= 3;
                    value++;
                }

                if(value == 1)
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
