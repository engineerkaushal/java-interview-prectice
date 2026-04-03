package java8feature;

import java.util.function.Function;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        Predicate<Integer> p = a -> a.equals(5);
        //System.out.println(p.test(5));

        Predicate<String> startLetter = x -> String.valueOf(x.toLowerCase().charAt(0)).equalsIgnoreCase("p");
        Predicate<String> endLetter = x -> String.valueOf(x.toLowerCase().charAt(x.length() - 1)).equalsIgnoreCase("S");
        Predicate<String> andResult = startLetter.and(endLetter);
        System.out.println(andResult.test("Kaushal Singh")); // Output -> false

        Predicate<String> orResult = startLetter.or(endLetter);
        System.out.println(orResult.test("Kaushal Singh"));// Output -> false

        Predicate<String> negateResult = startLetter.negate();
        System.out.println(negateResult.test("Kaushal Singh"));// Output -> true

    }
}
