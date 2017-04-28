package _04_27;

import java.util.TreeSet;

/*
 * wichtige zusätzliche Methoden aus der Klasse TreeSet
 * 				In Java 6 ist die Klasse TreeSet aktualisiert mit einigen Methoden...
 *
 * Begriff: Backed Collection
 * 				-tailSet
 * 				-headSet
 * 				-Subset
 */

public class TreeSetAPI {
    public static void main(String[] args) {

        TreeSet<Integer> abfahrtZeiten = new TreeSet<Integer>();
        abfahrtZeiten.add(1000);
        abfahrtZeiten.add(1015);
        abfahrtZeiten.add(1030);
        abfahrtZeiten.add(1045);
        abfahrtZeiten.add(1115);
        abfahrtZeiten.add(1215);
        abfahrtZeiten.add(1400);
        abfahrtZeiten.add(1500);
        abfahrtZeiten.add(1515);
        abfahrtZeiten.add(1715);
        System.out.println(abfahrtZeiten);

        //ich habe um 15:00 Feierabend und möchte wissen wann der erste Zug nach 15:00 fährt

        TreeSet<Integer> tailSet = new TreeSet<Integer>();
        tailSet = (TreeSet<Integer>) abfahrtZeiten.tailSet(1500,false);
        System.out.println(tailSet);
        System.out.println("Der erste Zug den Du nehmen kannst: " + tailSet.first() );

        //ich möchte den letzten zug vor 15:00

        System.out.println(abfahrtZeiten.headSet(1500, false).last());

        System.out.println("Der erste Zug den Du nehmen kannst: " + abfahrtZeiten.higher(1500) );

        System.out.println(tailSet);
        tailSet.add(1600);
        System.out.println(tailSet);
        tailSet.add(1800);
        System.out.println(tailSet);
        //tailSet.add(1455);
        System.out.println(tailSet);
//		TreeSet<Integer>ts = new TreeSet(tailSet);
//		ts.add(1455);
//		System.out.println(ts);



    }
}