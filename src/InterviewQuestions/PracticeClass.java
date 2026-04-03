package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeClass {
    public static void main(String[] args) {
        String inputValue = "Kaushal99s@1996aaaaaaaaaa";

        char target = 'a';
        char[] replacements = {'@', '&', '#', '$', '%'}; // dynamic replacement list

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char ch : inputValue.toCharArray()) {
            if (ch == target) {
                // If more 'a's than replacements exist, repeat last symbol
                if (count < replacements.length) {
                    result.append(replacements[count]);
                } else {
                    result.append(replacements[replacements.length - 1]);
                }
                count++;
            } else {
                result.append(ch);
            }
        }

        //System.out.println(result);
        char j = 'j' + 'k';
        System.out.println(j);

    }
}
