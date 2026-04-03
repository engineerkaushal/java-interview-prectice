package InterviewQuestions;


import java.util.*;
import java.util.stream.*;


public class InterviewQ_31_findMissingNumber {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 3, 6, 3, 5, 8);

        Integer maxValue = Collections.max(arr);

        List<Integer> filteredList = IntStream.rangeClosed(1, maxValue).boxed()
                .filter(f -> !arr.contains(f)).collect(Collectors.toList());


        //find all missing number
        System.out.println("All missing number : " + filteredList); //output: [2, 4, 7]

        //find first missing number
        System.out.println("First missing number : " + filteredList.get(0)); //output: 2

        //find last missing number
        System.out.println("Last missing number : " + filteredList.get(filteredList.size()-1)); //output: 7
    }
}
