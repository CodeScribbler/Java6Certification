package _04_28;

import java.util.HashMap;
import java.util.Map;

public class MapAPI {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<String, Integer>();

        hashMap.put("Dirk", 43);
        hashMap.put("Daniel", 40);
        hashMap.put("Reiner", 51);
        hashMap.put("Philipp", 29);

        hashMap.put("Dirk", 45);

        System.out.println(hashMap.size());
        System.out.println(hashMap);


        for(String index : hashMap.keySet()) {
            System.out.println(index + " - " + hashMap.get(index));
        }

    }

}
