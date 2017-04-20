package _03_13;

import java.util.Scanner;


public class Methoden {

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);

            System.out.println("Geben Sie bitten einen Umfang ein: ");
            float umfang = scan.nextFloat();

            System.out.println("Geben Sie bitten die Höhe ein: ");
            float hoehe = scan.nextFloat();

            scan.close();

            dosenBerechnung(umfang, hoehe);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }

    @SuppressWarnings( "all" )
    private static void dosenBerechnung(float umfang, float hoehe) {

        float d_boden = 0.0F,
                f_boden = 0.0F,
                f_mantel = 0.0F,
                f_gesamt = 0.0F,
                volumen = 0.0F,
                PI = 3.141592F;

        d_boden = umfang / PI;
        f_boden = (PI * (d_boden/2) * (d_boden/2));
        f_mantel = umfang * hoehe;
        f_gesamt = 2 * f_boden + f_mantel;
        volumen = f_boden * hoehe;

        System.out.println("Das Volumen der Dose beträgt: " + volumen);
    }

}
