package model;

import java.util.Random;

public class CustomerNumberGenerator {

    public String getNumber() {
        char[] chars = "ABCDEFGHIJKLNMOPQRSTUVWXYZ".toCharArray();
        char[] digits = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        sb.append(chars[random.nextInt(chars.length)]);
        sb.append(chars[random.nextInt(chars.length)]);

        for (int i = 0; i < 5; i++) {
            if (i == 3) sb.append("-");
            sb.append(digits[random.nextInt(digits.length)]);
        }
        return sb.toString();
    }


    private static CustomerNumberGenerator ourInstance = new CustomerNumberGenerator();

    public static CustomerNumberGenerator getInstance() {
        return ourInstance;
    }

    private CustomerNumberGenerator() {
    }
}
