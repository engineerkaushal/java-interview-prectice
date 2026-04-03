package collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListClass {
    public static void main(String[] args) {
        List<Integer> deleteOrAdd = new LinkedList<>();
        deleteOrAdd.add(5);
        deleteOrAdd.add(1);
        deleteOrAdd.add(4);
        deleteOrAdd.add(3);
        deleteOrAdd.add(2);

        deleteOrAdd.add(1, 6);
        deleteOrAdd.add(8);

        deleteOrAdd.add(null); // null allow


        System.out.println(deleteOrAdd);

        deleteOrAdd.remove(2);

        System.out.println(deleteOrAdd);
    }
}
