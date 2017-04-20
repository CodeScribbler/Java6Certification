package _03_13;

public class PrimitiveDatentypen {

    public static void main(String[] args) throws Exception  {

        float umfang, hoehe, d_boden, f_boden, f_mantel, f_gesamt, volumen;
        float PI = 3.141592F;

        System.out.println("Geben Sie bitten einen Umfang ein: ");
        umfang = System.in.read();

        System.out.println("Geben Sie bitten die Höhe ein: ");
        hoehe = System.in.read();
        d_boden = umfang / PI;

        System.out.println("Der Durchmesser des Dosenboden beträgt: " + d_boden);
        f_boden = (PI * (d_boden/2) * (d_boden/2));

        System.out.println("Die Fläche des Dosenboden beträgt: " + f_boden);
        f_mantel = umfang * hoehe;

        System.out.println("Die Mantelfläche der Dose beträgt: " + f_mantel);
        f_gesamt = 2 * f_boden + f_mantel;

        System.out.println("Die Gesamtfläche der Dose beträgt: " + f_gesamt);
        volumen = f_boden * hoehe;

        System.out.println("Das Volumen der Dosen beträgt: " + volumen);

    }

}
