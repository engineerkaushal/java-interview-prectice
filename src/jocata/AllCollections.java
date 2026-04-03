package jocata;

import java.util.ArrayList;
import java.util.List;

public class AllCollections {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Date");
        fruits.add("Banana");
        fruits.add("Cherry");
        //fruits.remove("Date");

        System.out.println(fruits);
    }
}
