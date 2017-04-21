package _04_20;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/*
 * NumberFormat
 * 				-format
 * 				-parse
 */
public class ZahlenWaehrung {
    public static void main(String[] args) {
        double d = 3.124;

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);//Währung
        NumberFormat n2f = NumberFormat.getCurrencyInstance(Locale.US);



        System.out.println(nf.format(d));
        System.out.println(n2f.format(d));

        nf = NumberFormat.getInstance(Locale.GERMANY);//Zahlen

        nf.setMaximumFractionDigits(5);
        nf.setMinimumFractionDigits(5);
        double z = 123456789.123456789;

        String s =	nf.format(z);
        try {
            Number doub = nf.parse("123456789.123456789");
            System.out.println(doub);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        nf.setMaximumFractionDigits(7);
        nf.format(z);
        System.out.println(nf.format(123456789.123456789));

    }

}

/*
 *
 * 		Date	 Calendar
 * 			Locale
 * 		DateFormat
 * 					-format
 * 					-parse
 *
 */

class Zusammenfassung {
    public static void main(String[] args) {

        Date d = new Date();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);

        DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);

        String s1 = df.format(d), s2 = df2.format(d);

        System.out.println(s1);
        System.out.println(df2.format(d));

        Date dde = null, dit = null;

        try {
            dde = df2.parse("20.04.17 ich schreibe hier ewtwas blödes...");
        } catch (ParseException e) {

            System.out.println(e.getMessage());
        }

        System.out.println(dde);

    }
//public static Date parse(String date, Locale loc) {
//
//	DateFormat df = DateFormat.getDateInstance(arg0, loc);
//
//}
}
