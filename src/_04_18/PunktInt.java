package _04_18;

import java.util.Random;
import java.io.Serializable;

public class PunktInt implements Serializable {

    private int x;
    private int y;

    public PunktInt() {
        this(1);
    }

    /*
    * generates a PunktInt-Object with coordinates between
    * -limit and +limit
    * @param limit, the maximum value of a coordinate, should be positive
    */
    public PunktInt(int limit) {
        Random r = new Random();
        x = r.nextInt(limit);
        if (r.nextInt(2) == 0) x = -x; y = r.nextInt(limit);

        if (r.nextInt(2) == 0) y = -y;
    }

    public PunktInt(int x, int y) {
        this.x = x; this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override public boolean equals(Object ob) {
        if ( ! (ob instanceof PunktInt)) return false;
        PunktInt p = (PunktInt) ob;                     // no ClassCastException here
        return (x==p.x && y==p.y);
    }

    @Override public String toString() {
        return "( " + x + ", "+ y +")";
    }
}