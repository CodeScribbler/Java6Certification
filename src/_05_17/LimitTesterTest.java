package _05_17;

import utility.Terminal;

public class LimitTesterTest {

    public static void main(String[] args) {
        double limit = Terminal.askDouble("Limit eingeben: ");
        LimitTester tester = new LimitTester();
        tester.sum("Karlsruhe", limit);
    }

}


// Test-Stub
class MessWertLieferant{
    private String ort;
    private int nValues = 10;

    public boolean wertVerfuegbar() {
        return (0 < nValues--);
    }

    public double naechsterWert() {
        return 1.0d;
    }

    public MessWertLieferant(String ort) {
        this.ort = ort;
    }
}
