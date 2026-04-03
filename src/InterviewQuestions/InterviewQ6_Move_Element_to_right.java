package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQ6_Move_Element_to_right {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,0,9,0,5,6,0,4);
        //output: [1,2,9,5,6,4,0,0,0]
        List<Integer> list = Stream.concat(input.stream().filter(f -> f != 0).collect(Collectors.toList()).stream()
                , input.stream().filter(f -> f == 0).collect(Collectors.toList()).stream())
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
