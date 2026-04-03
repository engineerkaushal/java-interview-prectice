package java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerJava8Feature {
    public static void main(String[] args) {
        Consumer<String> consumer = c -> System.out.println(c);
        consumer.accept("Kaushal");

        Consumer<List<Integer>> list = x -> {
            for (Integer i : x) {
                System.out.println(i + 100);
            }
        };
        list.accept(Arrays.asList(1, 2, 3, 4, 5));
    }
}
