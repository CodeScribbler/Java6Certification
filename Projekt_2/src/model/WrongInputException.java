package model;


public class WrongInputException extends Exception {

    private String wrongInput;

    public WrongInputException(String input) {
        this.wrongInput = input;
    }

    @Override
    public String getMessage() {
        return this.wrongInput;
    }

}
