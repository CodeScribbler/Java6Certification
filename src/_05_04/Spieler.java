package _05_04;


abstract class Spieler {

    String name;

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "name='" + name + '\'' +
                '}';
    }

}




