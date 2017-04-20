package _03_28.exercise;

public class Vehicle implements AsciiDisplayable {

    protected String position;
    protected String type;
    protected Object storageArea;

    @Override
    public void display() {
        System.out.println("Dispaymethode aus Vehicle");
    }
}

