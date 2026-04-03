package java8feature;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class VowelAndConsonant {
    public static void main(String[] args) {
        String input = "ka3@ushal";

        Map<String, Long> customGroup = input.chars().distinct().filter(Character::isAlphabetic)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> "aeiou".indexOf(ch) >= 0 ? "Vowel" : "Consonant",  // custom key: vowel या consonant
                        Collectors.counting()
                ));

        System.out.println(customGroup);

        List<String> names = Arrays.asList("Kaushal2@", "Ravi 12$5", "Suman");
        List<Character> vowelsSet = Arrays.asList('a', 'e', 'i', 'o', 'u');

        Map<String, Map<String, Long>> mapMap = names.stream().collect(Collectors.toMap(name -> name, name -> {
                    Map<String, Long> innerMap = new HashMap<>();

                    long vCount = name.toLowerCase().chars().distinct().mapToObj(m -> (char) m)
                            .filter(Character::isLetter)
                            .filter(f -> vowelsSet.contains(f)).count();

                    long cCount = name.toLowerCase().chars().distinct().mapToObj(m -> (char) m)
                            .filter(Character::isLetter)
                            .filter(f -> !vowelsSet.contains(f)).count();

                    long nCount = name.toLowerCase().chars().distinct().mapToObj(m -> (char) m)
                            .filter(Character::isDigit)
                            .count();
                    long notDisitOrLetterCount = name.toLowerCase().chars().distinct().mapToObj(m -> (char) m)
                            .filter(f -> !Character.isLetterOrDigit(f))
                            .count();

                    innerMap.put("Vowels", vCount);
                    innerMap.put("Consonants", cCount);
                    innerMap.put("Digit", nCount);
                    innerMap.put("spclChar", notDisitOrLetterCount);
                    return innerMap;
                }
        ));

        System.out.println(mapMap);

    }
}
