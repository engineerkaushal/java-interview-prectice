package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InterviewQ10_ReassignSortedName {
    public static void main(String[] args) {

        String[] input = {"1-Kaushal", "10-Aakash", "2-Saurabh", "3-Shivani"};
        // output: [1-Aakash, 2-Kaushal, 3-Saurabh, 4-Shivani]


        String[] result = getReAssigningSortedResult(input);
        System.out.println(Arrays.toString(result));
    }

    public static String[] getReAssigningSortedResult(String[] input) {
        List<Integer> number = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();

        Arrays.stream(input).forEach(v -> {
            number.add(Integer.valueOf(v.split("-")[0]));
            names.add(v.split("-")[1]);
        });

        Collections.sort(number);
        Collections.sort(names);

        for (int i = 0; i < number.size(); i++) {
            finalResult.add(number.get(i) + "-" + names.get(i));
        }

        String[] toArray = finalResult.stream().toArray(String[]::new);

        return toArray;
    }
}
