package _04_07;

public class ExceptionsInJava {

    public static void main(String[] args ) {

        try {
            test(new int[] {15,16,19,25,27});
            double v = calculateAverageTempBerlin(new int[] {15,16,190,25,27});

            System.out.println("letzte Anweisung im Try Block");
        }
        catch (Exception e) {
            System.out.println("Erste Anweisung im Catch Block");
            System.out.println(e.getMessage());
        }
        //System.out.println(v);
    }

    public static double calculateAverageTempBerlin(int[] ia) throws Exception {
        double result = 0;
        for(int t : ia) {
            if(t >= 30 && t <= 40) result += t;
            else throw new Exception("Illegal Temp " + t);
        }
        System.out.println("vor return result");
        return result / ia.length;
    }

    public static  void test(int[] a) throws Exception {
        double d = calculateAverageTempBerlin(a);

        System.out.println("Average Temp: " + d);
    }


}
