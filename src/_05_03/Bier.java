package _05_03;


public class Bier extends Getraenk{
    private String brauerei;
    public Bier(String brauerei){
        this.brauerei = brauerei;
    }
    @Override
    public String toString() {
        return "Bier [brauerei=" + brauerei + "]";
    }
    public String getBrauerei() {
        return brauerei;
    }

}