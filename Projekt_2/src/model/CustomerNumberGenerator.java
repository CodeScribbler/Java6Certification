package model;


public class CustomerNumberGenerator {
    private static CustomerNumberGenerator ourInstance = new CustomerNumberGenerator();

    public static CustomerNumberGenerator getInstance() {
        return ourInstance;
    }

    private CustomerNumberGenerator() {
    }
}
