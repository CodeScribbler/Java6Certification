package _04_10;

/*
 * Overriding:
 * 				1. Sichtbarkeit darf nicht eingeschränkt werden
 * 				2. Rückgabewerttyp muss covariant
 * 				3.Es darf keine neue checked Exception geworfen werden
 */

public class Overloading {

    public static void main(String[] args) {

    }

}


class CA {
    public void m (int i)  {
        System.out.println("Methode M aus CA");
    }

}

class CB extends CA {
    public void m (int i)  {
        System.out.println("Methode M aus CB");
    }
}