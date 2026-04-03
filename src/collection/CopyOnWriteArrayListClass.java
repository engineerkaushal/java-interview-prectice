package collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListClass {
    public static void main(String[] args) {
        List<String> getOrModify = new CopyOnWriteArrayList<>();
        getOrModify.add("M");
        getOrModify.add("A");
        getOrModify.add("D");
        getOrModify.add("B");
        getOrModify.add("F");

        System.out.println(getOrModify);

        getOrModify.add(1, "O");

        getOrModify.add(null); // null allow

        System.out.println(getOrModify);

        Iterator<String> iterator = getOrModify.iterator();
        while (iterator.hasNext()) {
            System.out.println("Has next : " + iterator.next());
            getOrModify.add("P");
        }

        System.out.println(getOrModify);
    }
}
