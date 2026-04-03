package collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetClass {
    public static void main(String[] args) {
        Set<String> getValue = new LinkedHashSet<>();

        getValue.add("D");
        getValue.add("A");
        getValue.add("C");
        getValue.add("D");
        getValue.add("B");

        getValue.add(null); // Insertion order preserved

        System.out.println(getValue);
    }
}
