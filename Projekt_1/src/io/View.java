package io;


public class View {

    private View() {}

    public static void mainMenu() {
        System.out.println("\n --- Bmi Calculator --- \n");
        System.out.println("       Show entries:  1");
        System.out.println("      Create person:  2");
        System.out.println("            Control:  3");
        System.out.println("\n               Exit:  0");
        System.out.println(" --------------------- \n");
    }

    public static void subMenuControl() {

    }

    public static void showEntriesMenu() {
        System.out.println("\n --- Show entries --- \n");
        System.out.println("             Regular:  1");
        System.out.println("      Sorted by name:  2");
        System.out.println("    Sorted by gender:  3");
        System.out.println("              Search:  4");
        System.out.println("\n              Exit:  0");
        System.out.println(" --------------------- \n");
    }

}
