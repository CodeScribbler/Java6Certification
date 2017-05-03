package _05_03;

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