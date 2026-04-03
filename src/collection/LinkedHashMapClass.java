package collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapClass {
    public static void main(String[] args) {
        Map<String, String> mapValue = new LinkedHashMap<>();

        mapValue.put("D", "AB");
        mapValue.put("B", "BC");
        mapValue.put("C", "CD");
        mapValue.put("A", "DE");
        mapValue.put("F", "EF");

        mapValue.put("F", "EFG");// If key is same value will be override

        mapValue.put(null, "TEST");

        System.out.println(mapValue);// Insertion order preserved
    }
}
