package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        Vector<String> getValue = new Vector<>();
        getValue.add("M");
        getValue.add("A");
        getValue.add("D");
        getValue.add("B");
        getValue.add("F");

        getValue.add(1, "O");

        getValue.add(null); // null allow

        System.out.println(getValue);

        Iterator<String> stringIterator = getValue.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
            getValue.add("G");// It will get ConcurrentModificationException because it will lock complete object
        }
    }
}
