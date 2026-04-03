package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewQ17_FindNumberFromListOfString {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("abc1", "abcd","1231",null,"");
        Map<String, Set<String>> listMap = input.stream()
                .filter(f -> f != null && !f.isEmpty())
                .collect(Collectors.toMap(m -> m, m -> {
                    return m.chars()
                            .mapToObj(obj -> (char) obj).filter(Character::isDigit).map(String::valueOf).collect(Collectors.toSet());
        }));

        System.out.println(listMap);
    }
}
