package util;


public class GenderParseException extends Exception {

    private String wrongInput;

    public GenderParseException(String input) {
        this.wrongInput = input;
    }

    @Override
    public String getMessage() {
        return "Incorrect input: " + wrongInput + " , the procedure will restart!";
    }

}