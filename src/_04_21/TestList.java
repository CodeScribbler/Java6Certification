package _04_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class TestList {
    public static void main(String[] args) {
        int [] ia = new int[3];
        ia[0] = 1; ia[1] = 3; ia[2] = 5;

        List<Integer> list = new ArrayList<Integer>();//Vector, LinkedList
        list.add(new Integer(3));list.add(new Integer(1));list.add(new Integer(5));
        //list.add(new String("Abc"));

        int sum = 0;
        for (int i = 0; i < ia.length; i++) {
            sum += ia[i];
        }
        //	System.out.println(sum);

        int sum2 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        //System.out.println(sum);

        //System.out.println(ia);
        System.out.println(list);
        list.add(1, 7);
        //	System.out.println(list);

        list.remove(new Integer(7));
        //System.out.println(list);
//
//			Collections.sort(list);
//			System.out.println(list);
//			Collections.shuffle(list);
//			System.out.println(list);
        List<Box> boxList = new ArrayList<Box>();
        boxList.add(new Box(3, "Kuchen"));
        boxList.add(new Box(1, "Apfel"));
        boxList.add(new Box(2, "Kaffee"));
//        System.out.println("Unsortiert");
//        System.out.println(boxList);
//
//        Collections.sort(boxList);
//        System.out.println("sortiert nach Preis:");
//        System.out.println(boxList);
//        Collections.sort(boxList, new SortiereNachInhalt());
//        System.out.println("sortiert nach Inhalt:");
//        System.out.println(boxList);
//        Collections.sort(list);
        //System.out.println(Collections.binarySearch(boxList, 3));
        System.out.println(Collections.binarySearch(boxList, new Box(100, "XyZ"), new SortiereNachInhalt()));

    }

}
class C{
    private String s;

    public String getS() {
        return s;
    }

}



class SortiereNachInhalt implements Comparator<Box> {

    @Override
    public int compare(Box box1	, Box box2) {// 0 - +
        return box1.inhalt.compareTo(box2.inhalt);
        //return 0;
    }

}

