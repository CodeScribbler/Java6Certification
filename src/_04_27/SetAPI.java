package _04_27;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * HashSet vs TreeSet
 *
 * 	Gemeinsamkeit					Unterschiede
 * 		Duplikatsfrei				-unsorted /sorted
 * 									-TreeSet hat zusätzliche praktisch nützliche Methoden
 * 									-Performance: HashSet Performanter (add, remove, contains, size)
 * 													HashSet: O(1), TreeSet: log(n)
 * 									-HashSet kann null als Element beinhalten, und TreeSet nicht -> NPE
 *
 * Achtung:
 * 			-Für HashSet sind hashCode und equals relevant und für TreeSet Comparable bzw Comparator (compareTo, copmare)
 *
 */

public class SetAPI {
    public static void main(String[] args) {
        Set s = new HashSet();
        Object o = null;
        //s.add(null);
        //s.add(null);
        //s.add(o);
        //s.add(new Object());

        s.add("abc");//
        s.add(3);//Autoboxing: new Integer(3)
//		s.add(false);
//		s.add(new Long(3));


        System.out.println(s);

        Set ts = new TreeSet(s);
        System.out.println(ts);




    }

}