package model;

import util.GenderParseException;

public enum Gender {

    MALE, FEMALE;

    public static Gender parseGender(String input) throws GenderParseException {
        if (!input.isEmpty()) {
            if (input.equalsIgnoreCase("M")) return Gender.MALE;
            if (input.equalsIgnoreCase("F")) return Gender.FEMALE;
        }
        throw new GenderParseException(input);
    }

}