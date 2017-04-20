package _04_06;

import java.util.Scanner;

public class Enum {

    private static String value = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Direction: ");
        value = Direction.getNeighbor(scan.next());
        System.out.println(value);

    }
}


enum Direction{

    NORTH, EAST, SOUTH, WEST;

    public static String getNeighbor(String direction) {
        return (direction.equalsIgnoreCase(Direction.NORTH.name()) ? Direction.WEST + " " + Direction.EAST
                : (direction.equalsIgnoreCase(Direction.EAST.name()) ? Direction.NORTH + " " + Direction.SOUTH
                : (direction.equalsIgnoreCase(Direction.SOUTH.name()) ? Direction.WEST + " " + Direction.EAST
                : (direction.equalsIgnoreCase(Direction.WEST.name()) ? Direction.NORTH + " " + Direction.SOUTH : " \n  ERROR: WRONG USER INPUT!"))));
    }
}