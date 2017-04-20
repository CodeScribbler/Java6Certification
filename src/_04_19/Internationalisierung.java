package _04_19;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Internationalisierung {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance(Locale.GERMAN);
        Calendar c1 = Calendar.getInstance(Locale.GERMAN);
        Calendar c2 = Calendar.getInstance(Locale.GERMAN);
        System.out.println(c.getTime());

        c1.add(Calendar.MONTH, 12);
        System.out.println(c1.getTime());

        c2.roll(Calendar.MONTH, 12);
        System.out.println(c2.getTime());


        DateFormat df = DateFormat.getDateInstance();
        String datum = df.format(c.getTime());
        System.out.println(datum);

        df = DateFormat.getDateInstance(DateFormat.FULL);
        datum = df.format(c.getTime());
        System.out.println(datum);
    }

}