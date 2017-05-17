package model;

import java.util.Random;

public class IBANGenerator {

    public String getNumber() {
        char[] digits = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            if (i == 3) sb.append("-");
            sb.append(digits[random.nextInt(digits.length)]);
        }

        return sb.toString();
    }


    private static IBANGenerator ourInstance = new IBANGenerator();

    public static IBANGenerator getInstance() {
        return ourInstance;
    }

    private IBANGenerator() {}

}
