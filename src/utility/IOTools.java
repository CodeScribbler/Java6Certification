package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class IOTools {
    private static BufferedReader in;
    private static StringTokenizer eingabe;
    private static String zeichenkette;

    private IOTools() {
    }

    public static void flush() {
        eingabe = null;
    }

    private static void init() {
        zeichenkette = null;
        if(eingabe == null || !eingabe.hasMoreTokens()) {
            while(eingabe == null || !eingabe.hasMoreTokens()) {
                eingabe = new StringTokenizer(readLine());
            }

        }
    }

    private static void error(Exception var0, String var1) {
        System.out.println("Eingabefehler " + var0);
        System.out.println("Bitte Eingabe wiederholen...");
        System.out.print(var1);
    }

    public static String readLine(String var0) {
        flush();
        String var1 = "";
        System.out.print(var0);

        try {
            var1 = in.readLine();
        } catch (IOException var3) {
            System.err.println("" + var3 + "\n Programm abgebrochen...\n");
            System.exit(1);
        }

        if(var1 == null) {
            System.err.println("Dateiende erreicht.\nProgramm abgebrochen...\n");
            System.exit(1);
        }

        return var1;
    }

    public static int readInteger(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                int var1 = Integer.parseInt(eingabe.nextToken());
                return var1;
            } catch (NumberFormatException var3) {
                error(var3, var0);
                init();
            }
        }
    }

    public static long readLong(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                long var1 = Long.parseLong(eingabe.nextToken());
                return var1;
            } catch (NumberFormatException var4) {
                error(var4, var0);
                init();
            }
        }
    }

    public static double readDouble(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                double var1 = Double.valueOf(eingabe.nextToken()).doubleValue();
                return var1;
            } catch (NumberFormatException var4) {
                error(var4, var0);
                init();
            }
        }
    }

    public static float readFloat(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                float var1 = Float.valueOf(eingabe.nextToken()).floatValue();
                return var1;
            } catch (NumberFormatException var3) {
                error(var3, var0);
                init();
            }
        }
    }

    public static short readShort(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                short var1 = Short.valueOf(eingabe.nextToken()).shortValue();
                return var1;
            } catch (NumberFormatException var3) {
                error(var3, var0);
                init();
            }
        }
    }

    public static byte readByte(String var0) {
        System.out.print(var0);
        init();

        while(true) {
            try {
                byte var1 = Byte.valueOf(eingabe.nextToken()).byteValue();
                return var1;
            } catch (NumberFormatException var3) {
                error(var3, var0);
                init();
            }
        }
    }

    public static boolean readBoolean(String var0) {
        String var1;
        for(var1 = readString(var0); !var1.equals("true") && !var1.equals("false"); var1 = readString()) {
            error(new NumberFormatException("For input string: \"" + var1 + "\""), var0);
        }

        return var1.equals("true");
    }

    public static String readString(String var0) {
        System.out.print(var0);
        init();
        return eingabe.nextToken();
    }

    public static char readChar(String var0) {
        String var1;
        for(var1 = readString(var0); var1.length() != 1; var1 = readString()) {
            error(new NumberFormatException("For input string: \"" + var1 + "\""), var0);
        }

        return var1.charAt(0);
    }

    public static String readLine() {
        return readLine("");
    }

    public static int readInteger() {
        return readInteger("");
    }

    public static int readInt() {
        return readInteger("");
    }

    public static int readInt(String var0) {
        return readInteger(var0);
    }

    public static long readLong() {
        return readLong("");
    }

    public static double readDouble() {
        return readDouble("");
    }

    public static short readShort() {
        return readShort("");
    }

    public static byte readByte() {
        return readByte("");
    }

    public static float readFloat() {
        return readFloat("");
    }

    public static char readChar() {
        return readChar("");
    }

    public static String readString() {
        return readString("");
    }

    public static boolean readBoolean() {
        return readBoolean("");
    }

    public static String toString(double var0) {
        return !Double.isInfinite(var0) && !Double.isNaN(var0)?(new BigDecimal(var0)).toString():"" + var0;
    }

    static {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
}