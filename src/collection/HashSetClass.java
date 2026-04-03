package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetClass {
    public static void main(String[] args) {
        Set<String> getValue = new HashSet<>();
        getValue.add("D");
        getValue.add("A");
        getValue.add("C");
        getValue.add("D");
        getValue.add("B");

        getValue.add(null); // Insertion order not preserved and null will always insert in first place

        System.out.println(getValue);

    }
}
