package model;

public class IBANGenerator {

    private static IBANGenerator ourInstance = new IBANGenerator();

    public static IBANGenerator getInstance() {
        return ourInstance;
    }

    private IBANGenerator() {}

}
