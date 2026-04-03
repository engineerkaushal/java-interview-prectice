package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class InterviewQ2_Subsequence_in_array {
    public static void main(String[] args) {
        int []value = {15, 11, 17, 13, 7, 9, 1};

        int []input1 = {13, 9}; //output : true
        int []input2 = {17, 11}; //output : false

        System.out.println(getResult(value, input1));
    }

    public static boolean getResult(int[] value, int[] input) {
        List<Integer> result = new ArrayList<>();
        if (value.length >= input.length) {
            int count = 0;
            for (int i = 0; i < value.length; i++) {
                if (count < input.length && value[i] == input[count]) {
                    result.add(value[i]);
                    count++;
                }
            }
            if (result.size() == input.length)
                return true;
            else
                return false;
        } else {
            throw new RuntimeException("Invalid input !");
        }
    }
}
