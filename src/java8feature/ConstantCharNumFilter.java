package java8feature;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstantCharNumFilter {
    public static void main(String[] args) {
        String input =  "Ka1#2s1sgh";

        List<String> digit = input.chars()
                .filter(f -> Character.isDigit(f))
                .mapToObj(m -> String.valueOf((char) m))
                .collect(Collectors.toList());


        List<String> alpha = input.chars()
                .filter(f -> Character.isAlphabetic(f))
                .mapToObj(m -> String.valueOf((char) m))
                .collect(Collectors.toList());

        List<Character> spacl = input.chars()
                .filter(f -> !Character.isLetterOrDigit(f))
                .mapToObj(m -> (char) m)
                .collect(Collectors.toList());

        System.out.println(digit);
        System.out.println(alpha);
        System.out.println(spacl);
    }
}
