package _04_11;

public class Assertion {

    public static void main(String[] args) {

        int x = divideMitAssert(20, 0);
        System.out.println(x);

    }

    private static int divide(int x, int y) {
        int result;
        if (y == 0) {
            result = 0;
        }
        else {
            result = x / y;
        }
        return result;
    }

    private static int divideMitAssert(int x, int y) {
        assert (y != 0) ;
        int result;
        result = x / y;
        return result;
    }

}