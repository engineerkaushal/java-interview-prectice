package java8feature;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T1 {
    public static void main(String[] args) {

        List<Integer> list1 = IntStream.range(1, 11).boxed().filter(f -> f%2 != 0).collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(1, 11).boxed().filter(f -> f%2 == 0).map(m -> m*m).collect(Collectors.toList());

        //add two list
        List<Integer> mergedList1 = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());

        List<Integer> mergedList2 = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        String s = "Kaushal Singh";

        List<Character> list = s.chars().mapToObj(m -> (char) m).filter(f -> !f.toString().equalsIgnoreCase(" ")).collect(Collectors.toList());
        //System.out.println(list);

        Map<Character, Long> map = s.trim().chars().mapToObj(m -> (char) m)
                .filter(f -> !f.toString().equalsIgnoreCase(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        List<Character> singleChar = map.entrySet().stream().filter(f -> f.getValue() == 1).map(m -> m.getKey()).collect(Collectors.toList());
        List<Character> repeatedChar = map.entrySet().stream().filter(f -> f.getValue() > 1).map(m -> m.getKey()).collect(Collectors.toList());
        //System.out.println("Single Chars are : " + singleChar);
        //System.out.println("Repeated Chars are : " + repeatedChar);

    }
}
