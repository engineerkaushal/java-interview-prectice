package java8feature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveZeroElementToRight {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 0, -3, 0, 5, -2, 0, 8, 0, -4);
        List<Integer> zeroElement = input.stream().filter(f -> f==0).collect(Collectors.toList());
        List<Integer> nonZeroElement = input.stream().filter(f -> f!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<Integer> finalElement = Stream.concat(nonZeroElement.stream(), zeroElement.stream()).collect(Collectors.toList());
        System.out.println(finalElement);
    }
}
