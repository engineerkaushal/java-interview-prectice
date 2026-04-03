package InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Collectors के Methods
public class InterviewQ9_All_Collectors_Methods {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "orange", "apple");

        //TODO 1. To Collection / To List / To Set

        //a. toList() → elements को List में collect करता है।
        List<String> list = words.stream().collect(Collectors.toList());


        //b. toSet() → elements को Set में collect करता है।
        Set<String> set = words.stream().collect(Collectors.toSet());


        //c. toCollection(Supplier<C>) → किसी specific collection type (जैसे LinkedList, TreeSet) में collect करता है।
        LinkedList<String> linked = words.stream().collect(Collectors.toCollection(LinkedList::new));

        //TODO 2. To Map


    }
}
