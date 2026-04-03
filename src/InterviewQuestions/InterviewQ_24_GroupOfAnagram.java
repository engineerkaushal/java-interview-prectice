package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewQ_24_GroupOfAnagram {
    public static void main(String[] args) {

        List<String> input = Arrays.asList("eat", "tea", "ate", "tan", "nat", "bat");

        Map<String, List<String>> map = input.stream()
                .collect(Collectors.groupingBy(InterviewQ_24_GroupOfAnagram::sortString));

        // -- If you want only grater then 1 word in anagram so uncomment below code
        /*Map<String, List<String>> listMap = map.entrySet().stream()
                .filter(f -> f.getValue().size() > 1)
                .collect(Collectors.toMap(mp -> mp.getKey(), mm -> mm.getValue(), (a, b) -> b));*/

        System.out.println(map);
    }

    public static String sortString(String input) {
        //------Traditional Approach-------
        /*char[] ch = input.toCharArray();
        Arrays.sort(ch);
        return new String(ch);*/

        //------Java 8----------------
        return input.chars()
                .mapToObj(m -> (char)m)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
