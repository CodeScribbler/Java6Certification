package _04_26;

public class Tokenization {

    public static void main(String[] args) {
        String source = "This is a test";

        String[] personen = source.split("\\s");
        System.out.println(personen.length);

        for (int i = 0; i < personen.length; i++) {
            System.out.println(personen[i]);
        }


/*        Scanner scan = new Scanner(source);
        int count = 0;
        while (scan.hasNext()) {
            System.out.println(scan.next());
            if(++count == 2) break;
        }

        String test = "100 false 400 test";
        int summe = 0;
        Scanner sc = new Scanner(test);

        while (sc.hasNext()) {
            if(sc.hasNextInt()) summe+= sc.nextInt();
        }*/
    }

}
