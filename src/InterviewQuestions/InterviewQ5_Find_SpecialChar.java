package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ5_Find_SpecialChar {
    public static void main(String[] args) {
        List<String> value = Arrays.asList("Kau!sh@al", "Saur@bah","A$nu", "kk9", "!sac9");

        System.out.println(getSpecialChar(value));
    }

    public static List<String> getSpecialChar(List<String> input) {
        List<String> result = new ArrayList<>();
        if (!input.isEmpty()) {
            input.forEach(v -> {
                String s1 = v.chars().mapToObj(m -> (char) m)
                        .filter(f -> !Character.isLetterOrDigit(f))
                        .map(s -> String.valueOf(s)).collect(Collectors.joining());
                if (!s1.isEmpty())
                    result.add(v + " = " + s1);
            });
        } else {
            throw new RuntimeException("Array List is empty");
        }
        return result;
    }
}
