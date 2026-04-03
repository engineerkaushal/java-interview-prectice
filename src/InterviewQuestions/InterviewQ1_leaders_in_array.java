package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewQ1_leaders_in_array {
    public static void main(String[] args) {
        int []value = {15, 11, 17, 13, 7, 9, 1};
        //output: {17, 13, 9, 1}
        Integer maxValue = Integer.MIN_VALUE;
        List<Integer> addList = new ArrayList<>();
        for (int i = value.length - 1; i >= 0; i--) {
            if (value[i] > maxValue) {
                addList.add(value[i]);
                maxValue = value[i];
            }
        }
        Collections.reverse(addList);
        System.out.println(addList);
    }
}
