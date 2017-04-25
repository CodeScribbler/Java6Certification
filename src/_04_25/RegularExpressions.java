package _04_25;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    public static void main(String[] args) {

       /* Pattern patt = Pattern.compile("xy");
        Matcher m = patt.matcher("xy Ebene ");

        while(m.find()) {
            System.out.println(m.start() + " " + m.group() + " " + m.end());        // 0 xy 2
        }

        Matcher m2 = Pattern.compile("aba").matcher("abababa");

        while(m2.find()) {
            System.out.println(m2.start() + " " + m2.group() + " " + m2.end());
        }

        Matcher m3 = Pattern.compile("[^0-9]").matcher("a_ba3bab5a&$ ()");

        while(m3.find()) {
            System.out.println(m3.start() + " " + m3.group() + " " + m3.end());
        }*/

        /*String source = "Ich habe 2 Kinder, der yohanes ist 11  jahre alt und Rahel 15";

        Matcher match = Pattern.compile("\\d+").matcher(source);

        while(match.find()) {
            System.out.println(match.start() + " " + match.group() + " " + match.end());
        }*/


        String name = "ab34ef";

        Matcher match = Pattern.compile("(\\d*)").matcher(name);

        while(match.find()) {
            System.out.println(match.start() + " " + match.group());
        }

    }

}
