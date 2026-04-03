package collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashTableClass {
    public static void main(String[] args) {
        Hashtable<String, String>  table = new Hashtable<>();

        table.put("F", "AB");
        table.put("D", "CD");
        table.put("A", "EF");
        table.put("C", "GH");
        table.put("E", "IJ");

        //table.put(null, "IJ"); // we can't insert null key
        //table.put("G", null); // we can't insert null value


        System.out.println(table);// Insertion order not preserved

        Iterator<Map.Entry<String, String>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            table.put("H", "KL"); // ConcurrentModificationException
        }
    }
}
