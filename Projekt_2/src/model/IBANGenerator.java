package model;

import java.util.Random;

public class IBANGenerator {

    public String getNumber() {
        char[] digits = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        sb.append("DE21");

        for (int i = 0; i < 17; i++) {
            sb.append(digits[random.nextInt(digits.length)]);
        }

        return sb.toString();
    }


    private static IBANGenerator ibanInstance = new IBANGenerator();

    public static IBANGenerator getInstance() {
        return ibanInstance;
    }

    private IBANGenerator() {}

}
