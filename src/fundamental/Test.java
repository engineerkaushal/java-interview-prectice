package fundamental;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public Test() {
        System.out.println("Constructor");
    }

    void method1() {
        System.out.println("method");
    }

    {
        System.out.println("Instance block");
    }

    static {
        System.out.println("static block");
    }

    public static void main(String[] args) {
        System.out.println("Test Test");
        new Test().method1();

        List<Integer> lst = Arrays.asList(1,2,3,4,5);
        Integer integerList = lst.stream().sorted(Collections.reverseOrder()).skip(10).findFirst().orElse(null);
        System.out.println(integerList);

    }

}
