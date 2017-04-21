package model;

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


class GenderParseException extends Exception {

    private String wrongInput;

    public GenderParseException(String input) {
        this.wrongInput = input;
    }

    @Override
    public String getMessage() {
        return "Incorrect input: " + wrongInput + " , the procedure will restart!";
    }

}