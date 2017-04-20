package _04_18;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class TestFilesWithPunktInt {

    private static String objFILE = "\\C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\temp1.txt";
    private static String stringFILE = "\\C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\temp2.txt";

    public static void main(String[] args) {

        try
        {
            System.out.println("\n Ihre Eingabe: " + charLesen(new char[] {'A', 'B', 'C'}) + "\n\n");
        }
        catch (IOException e) { e.getMessage(); }
        catch (IllegalArgumentException e) { e.printStackTrace(); }

        PunktInt[] arr = generatePunkte(10, 20);

        try
        {
            saveAsObject(arr);
            printFromObject();

            saveAsPunkten(arr);
            printFromString();
        }
        catch (IOException e) { e.printStackTrace(); }

    }

    private static char charLesen(char[] car) throws IllegalArgumentException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Zeichen eingeben: ");
        char intput = scan.next().charAt(0);

        for(char iterator : car) {
            if (iterator == intput) {
                return intput;
            }
        }
        throw new IllegalArgumentException("WRONG INPUT!");
    }

    private static PunktInt[] generatePunkte(int numberPoints, int limit) {
        PunktInt[] arr = new PunktInt[numberPoints];
        for(int i = 0; i < numberPoints; i++) {
            arr[i] = new PunktInt(limit);
        }
        return arr;
    }

    private static void saveAsObject(PunktInt[] arr) throws IOException {

        ObjectOutputStream objOutStream = null;

        try {
            objOutStream = new ObjectOutputStream(new FileOutputStream(new File(objFILE)));
            objOutStream.writeObject(arr);
            objOutStream.flush();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NotSerializableException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(objOutStream != null)
                    objOutStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void saveAsPunkten(PunktInt[] arr) throws IOException {
        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(stringFILE));

            for (PunktInt iterator : arr) {
                bw.write(iterator.toString());
            }

        } catch (IOException e) { e.getMessage(); }

        finally {

            try {
                if (bw != null) bw.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void printFromObject() throws IOException {

        ObjectInputStream objInStream = null;

        try {

            objInStream= new ObjectInputStream(new FileInputStream(new File(objFILE)));
            PunktInt[] streamArr = (PunktInt[]) objInStream.readObject();

            System.out.println("\n\n Ausgabe PunktInt als Objekt: ");

            for (PunktInt iterator : streamArr) {
                System.out.print(iterator.toString() + " ");
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally{
            try {
                if(objInStream != null) objInStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printFromString() throws IOException {
        FileReader fr = null;

        try {

            File file = new File(stringFILE);
            fr = new FileReader(file);
            String str;

            char[] temp = new char[(int) file.length()];

            fr.read(temp);

            str = new String(temp);

            System.out.println("\n\n Ausgabe PunktInt als String: ");

            StringTokenizer tok = new StringTokenizer(str, "()", false);

            while (tok.hasMoreTokens())
                System.out.print(tok.nextToken() + " ");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(fr != null) fr.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}