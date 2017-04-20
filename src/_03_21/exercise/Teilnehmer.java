package _03_21.exercise;

public class Teilnehmer {

    private String name;
    private int registernummer;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name != null) this.name = name;
        else System.out.println("Die Eingabe des Namen war fehlerhaft!");
    }

    public int getRegisternummer() {
        return registernummer;
    }
    public void setRegisternummer(int registernummer) {
        if(registernummer > 0 ) this.registernummer = registernummer;
        else System.out.println("Die Registernummer muss größer 0 sein!");
    }

    public Teilnehmer(String name, int registernummer) {
        this.setName(name);
        this.setRegisternummer(registernummer);
    }

    public void ausgeben() {
        System.out.println("Teilnehmehmer: " + this.getName() +
                "\n Registernummer: " + this.getRegisternummer());
    }

}