package _03_28;

public class Lokomotive extends Schienenfahrzeug {

    private final byte anzahlLokomotive;
    private boolean zugFührer;            // true einsteigen, false aussteigen

    protected void fahrerEinsteigen() {
        if(this.zugFührer)
            System.out.println("Der Zugführer ist ausgestiegen, kurze Pause!");
        else System.out.println("Der Zugführer ist breits eingestiegen!");
    }

    protected void fahrerAussteigen() {
        if(!this.zugFührer)
            System.out.println("Der Zugführer ist ausgestiegen, kurze Pause!!");
        else System.out.println("Der Zugführer ist breits ausgestiegen!");
    }

    public Lokomotive(byte numberLokomotive) {
        this.anzahlLokomotive = numberLokomotive;
        this.zugFührer = true;
    }



}
