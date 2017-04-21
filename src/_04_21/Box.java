package _04_21;


import java.util.*;

public class Box implements Comparable<Box>{
    int price;
    String inhalt;
    C c;
    public Box(int price, String inhalt) {
        super();
        this.price = price;
        this.inhalt = inhalt;

    }
    @Override
    public String toString() {
        return "Box [price=" + price + ", inhalt=" + inhalt + "]";
    }

    @Override
    public int compareTo(Box other) {//gleich (0) kleiner (-) groesser (+)
//		if(this.price == other.price) return 0;
//		else if(this.price < other.price) return -1;
//		return 1;
        return new Integer(this.price).compareTo(other.price);
        //return this.inhalt.compareTo(other.inhalt);
        //return this.c.getS().compareTo(other.c.getS());
    }
}

class SortierVorgabe implements Comparator<Box> {


    @Override
    public int compare(Box o1, Box o2) {
        return 0;
    }
}
