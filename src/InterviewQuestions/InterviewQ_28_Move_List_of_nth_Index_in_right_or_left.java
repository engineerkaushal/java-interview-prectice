package InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQ_28_Move_List_of_nth_Index_in_right_or_left {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 2, 7, 9, 3, 6, 3, 7, 13, 43, 12);

        System.out.println(sortedList(input, 3));
    }

    public static List<Integer> sortedList(List<Integer> input, int noOfIndexShift) {
        if (noOfIndexShift <= input.size()) {

            List<Integer> shiftList = input.stream().limit(noOfIndexShift).collect(Collectors.toList());

            List<Integer> skipList = input.stream().skip(noOfIndexShift).collect(Collectors.toList());

            return Stream.concat(skipList.stream(), shiftList.stream()).collect(Collectors.toList());

            }
        return Collections.emptyList();
    }
}
