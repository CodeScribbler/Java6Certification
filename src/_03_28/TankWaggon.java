package _03_28;

public class TankWaggon extends Waggon {

    private double literFluessigkeit;
    private double maxKapazitaet;
    private boolean isToxic;


    public TankWaggon(double literFluessigkeit, double maxKapazitaet, boolean isToxic) {
        this.literFluessigkeit = literFluessigkeit;
        this.maxKapazitaet = maxKapazitaet;
        this.isToxic = isToxic;
        this.inhalt = inhalt;
    }


    public static void main(String[] args) {
        TankWaggon r = new TankWaggon(5, 50, false);
        Object object = new Object();

    }

    static void m() {

    }


}