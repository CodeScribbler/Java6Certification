package _05_17;

public class LimitTester {
    void sum(String ort, double limit) {
        MessWertLieferant source = new MessWertLieferant(ort); // zunächst ein MWL erzeugen
        double sum = 0.0d;
        int count = 0; // Anzahl Messwerte

        while (source.wertVerfuegbar()) { // solange Messwerte verfügbar sind
            sum += source.naechsterWert(); // sollen aufsummiert werden
            count++; // Anzahl Messwerte
            if (sum > limit) { // sobald die Summe das Limit überschreitet
                // Text ausgeben
                System.out.println(String.format("Limit bei Messwert Nr. %d ueberschritten!", count));
                // Methode sofort beenden
                return;
            }
        }
        // Keine Limit-Überschreitung
        System.out.println(String.format("Gesamtsumme ist %f.", sum)); // Summenwert ausgeben
    }
}
