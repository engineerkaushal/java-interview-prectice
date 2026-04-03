package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InterviewQ_29_Merge_kth_LinkedList {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> list = mergeEveryNthNodeOfLinkedList(input, 3);
        System.out.println(list);
    }

    public static List<Integer> mergeEveryNthNodeOfLinkedList(List<Integer> input, int node) {
        List<Integer> result = new ArrayList<>();
        int count = node - 1;
        for (int i = node - 1; i <= input.size(); i++) {
            if (count < input.size()) {
                result.add(input.get(count));
                count+=node;
            }
        }
        return result;
    }
}
