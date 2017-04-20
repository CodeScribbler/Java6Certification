package _03_15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise {


    public static void main(String[] args) {

        int value = getBetrag(-3);
        System.out.println(value);

        value = getAnzahlZiffern(5213);
        System.out.println(value);

//		value = getZiffernWert(1235, 2);
//		System.out.println(value);

        ersetzteZiffern(11111, 2, 0);

    }




    private static int getBetrag(int zahl) {
        return Math.abs(zahl);
    }

    private static int getAnzahlZiffern(int zahl) {
        return (zahl>0)? 1+getAnzahlZiffern(zahl/10) : 0;
    }


    public static int potenz(int zahl, int pot){

        if (pot==0)
            return 1;
        if (pot>0){

            return potenz(zahl, pot-1)*zahl;
        }
        if (pot<0){

            return 1/(potenz(zahl, -pot-1)*zahl);
        }
        return 0;
    }


    private static void ersetzteZiffern(int zahl, int stelle, int wert) {
        String  text    = Integer.toString(zahl);
        Matcher matcher = Pattern.compile(Integer.toString(stelle)).matcher( text );
        StringBuffer sb = new StringBuffer();
        while ( matcher.find())
            matcher.appendReplacement( sb, Integer.toString(wert) );
        matcher.appendTail( sb );
        System.out.println( sb );
    }
}