package java8FeaturePracticeCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class reverseList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("S");
        list.add("D");
        list.add("F");
        List<String> newList = list.stream().collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(newList);
        System.out.println(newList);
        /*Explanation
            Stream Creation: Convert the original list to a stream.
            Collection: Use Collectors.toCollection(LinkedList::new) to collect the stream elements into a LinkedList. A LinkedList is chosen because it allows efficient reversal.
            Reversing: Call Collections.reverse() on the collected LinkedList.*/
        List<String> list1 = new ArrayList<>();
        list1.add("Kaushal");
        list1.add("Saurabh");
        list1.add("Mom");
        list1.add("Dad");
        List<String> reversedItems = IntStream.rangeClosed(1, list1.size())
                .mapToObj(i -> list1.get(list1.size() - i)).collect(Collectors.toList());
        System.out.println(reversedItems);
        /*
        IntStream: Create an IntStream that generates a range from 1 to the size of the list.
        Mapping: Use mapToObj() to access elements from the original list in reverse order by calculating their indices.
        Collecting: Collect the results into a new list.
         */
    }
}
