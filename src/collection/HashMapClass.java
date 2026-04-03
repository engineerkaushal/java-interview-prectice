package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public static void main(String[] args) {
        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("D", "AB");
        mapValue.put("B", "BC");
        mapValue.put("C", "CD");
        mapValue.put("A", "DE");
        mapValue.put("F", "EF");

        mapValue.put("F", "EFG");// If key is same value will be override

        mapValue.put(null, "TEST");// null key will always insert in first index

        System.out.println(mapValue);// Insertion order not preserved
    }
}
