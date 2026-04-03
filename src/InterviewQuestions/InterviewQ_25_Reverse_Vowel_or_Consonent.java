package InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InterviewQ_25_Reverse_Vowel_or_Consonent {
    public static void main(String[] args) {
        String input = "Ramu";
        //output:  Ruma
        List<Character> vowels = Arrays.asList('a','e','i','o','u');

        List<Character> list = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .filter(vowels::contains)
                .collect(Collectors.toList());

        Collections.reverse(list);

        System.out.println(list);

        // Using AtomicInteger reverse Vowel
        AtomicInteger integer = new AtomicInteger(0);
        String s1 = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .map(v -> vowels.contains(v) ? list.get(integer.getAndIncrement()) : v)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Using AtomicInteger reverse Vowel : " + s1);

        // Using Iterator reverse Vowel
        Iterator<Character> iterator = list.iterator();
        String s2 = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .map(v -> vowels.contains(v) ? iterator.next() : v)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Using Iterator reverse Vowel : " + s2);

//---------------------------------Consonent-------------------------------------------------

        List<Character> consList = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .filter(v -> !vowels.contains(v))
                .collect(Collectors.toList());

        Collections.reverse(consList);

        System.out.println(consList);

        // Using AtomicInteger reverse Consonent
        AtomicInteger consInteger = new AtomicInteger(0);
        String s3 = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .map(v -> !vowels.contains(v) ? consList.get(consInteger.getAndIncrement()) : v)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Using AtomicInteger reverse Consonent : " + s3);

        // Using Iterator reverse Consonent
        Iterator<Character> consIterator = consList.iterator();
        String s4 = input.toLowerCase().chars()
                .mapToObj(m -> (char) m)
                .map(v -> !vowels.contains(v) ? consIterator.next() : v)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Using Iterator reverse Consonent : " + s4);
    }
}
