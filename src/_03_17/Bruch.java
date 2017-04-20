package _03_17;

public class Bruch {

    private int zaehler;
    private int nenner;

    public int getZaehler() {
        return zaehler;
    }
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    public int getNenner() {
        return nenner;
    }
    public void setNenner(int nenner) {
        this.nenner = nenner;
    }

    public Bruch() {
        this.zaehler = 3;
        this.nenner = 4;
    }

    public Bruch(int z, int n) {
        this.zaehler = z;
        this.nenner = n;
    }

    public void print() {
        System.out.println("Bruch: " + this.getZaehler() + "/" + this.getNenner());
    }

}
