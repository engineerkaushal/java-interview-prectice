package InterviewQuestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQ_26_CountDuplicateCharAndReplaceWithCount {
    public static void main(String[] args) {
        String input = "kaushalsinghdixit";
        Map<String, Long> longMap = input.chars()
                .mapToObj(m -> String.valueOf((char) m))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(longMap);


        String collect = input.chars().mapToObj(m -> String.valueOf((char) m))
                .map(v -> longMap.get(v) > 1 ? longMap.get(v) : v)
                .map(String::valueOf).collect(Collectors.joining());

        System.out.println(collect);
    }
}
