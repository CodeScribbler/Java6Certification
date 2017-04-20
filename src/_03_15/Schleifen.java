package _03_15;

public class Schleifen {

    public static void main(String[] args) {

        try {

//			short value = 0;
//			Scanner input = new Scanner(System.in);
//
//			System.out.println(" Geben Sie bitte die Anzahl der Wiederholungen ein:");
//			value = input.nextShort();
//			input.close();

            for(int i = 1; i <= 5; i++)
            {
                for(int j = 1; j <= i; j++)
                {
                    System.out.print( '*' );
                }
                System.out.println();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}