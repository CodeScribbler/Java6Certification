package _04_21;


import java.util.*;

public class Box implements Comparable<Box> {

    public static void main(String[] args) {
        Collection<Box> boxList = new ArrayList<Box>();

        Collections.binarySearch((List<? extends Comparable<? super Object>>) boxList, null);

        Collections.sort((List<Box>) boxList, new SortierVorgabe());
    }




    @Override
    public int compareTo(Box o) {

        return 0;
    }
}

class SortierVorgabe implements Comparator<Box> {


    @Override
    public int compare(Box o1, Box o2) {
        return 0;
    }
}
