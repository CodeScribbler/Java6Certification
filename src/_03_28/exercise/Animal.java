package _03_28.exercise;

public class Animal extends Genome implements AsciiDisplayable {

    private String name;
    private Genome genes;

    protected Animal() {}

    public void display(){
        System.out.println("Displaymethode aus Animal");
    }

//    public String toString() {
//        return this.getClass().getTypeName();
//    }

}

