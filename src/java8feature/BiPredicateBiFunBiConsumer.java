package java8feature;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateBiFunBiConsumer {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x % 2 == 0 && y % 2 == 0;
        System.out.println(biPredicate.test(8, 10));

        BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
        System.out.println(biFunction.apply("Kaushal", "Singh"));

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(4, 6);

    }
}
