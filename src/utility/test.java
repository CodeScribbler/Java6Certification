package utility;


import java.util.Iterator;
import java.util.PriorityQueue;


public class test {

    public static void main(String[] args) {
        PriorityQueue<String> pqs = new PriorityQueue<String>();
pqs.add("BBB");
pqs.add("CCC");
pqs.add("EEE");
pqs.add("DDD");
pqs.add("FFF");
pqs.add("EEE");
pqs.add("AAA");
System.out.println("toString");
System.out.println(pqs);

	System.out.println("iterator");
	Iterator<String> it = pqs.iterator();
	while (it.hasNext()) {
		System.out.print(it.next() + " ");

	}
	int n = pqs.size();
	System.out.println("\npoll");
	for (int i = 0; i < n; i++) {
		System.out.print(pqs.poll() + " ");//poll
}

pqs.add(null);
PriorityQueue<Auto> pqa = new PriorityQueue<Auto>();
pqa.add(new Auto());
pqa.add(new Auto());
    }

}

class Auto {

}