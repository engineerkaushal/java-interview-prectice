package collection;

import java.util.Arrays;
import java.util.List;

public class ArrayListClass {
    public static void main(String[] args) {
        List<String> getList = Arrays.asList("C", "A", "B", "D", "F", null, null);// null allow

        getList.set(0, "M");
        System.out.println(getList);
    }
}
