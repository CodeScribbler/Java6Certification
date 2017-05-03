package _05_02;

/*
 * Behälter
 *
 * Problem:	typisierte Flaschen
 * 					-Bierflasche
 * 					-Weinflasche
 * 						...
 */

public class MotivationGenerics {

}

abstract class Getraenk{

}
class Bier extends Getraenk{
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
abstract class Wein extends Getraenk{
    private String region;

    public Wein(String region) {
        super();
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Wein [region=" + region + "]";
    }

}
class WeissWein extends Wein{

    public WeissWein(String region) {
        super(region);

    }

}

class RotWein extends Wein{

    public RotWein(String region) {
        super(region);

    }

}