package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ11_Pelindram {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kaushal", "Saurabh", "Aman", "lashauk", "bharuas", "Kaushal", "Aba", "bCb");
        List<String> result = new ArrayList<>();
        list.stream().forEach(f -> {
            StringBuilder sb = new StringBuilder();
            char[] charValue = f.toCharArray();
            for (int i = charValue.length - 1; i >= 0 ; i--) {
                sb.append(charValue[i]);
            }
            if (f.toLowerCase().equalsIgnoreCase(sb.toString())) {
                result.add(f.toUpperCase());
            }
        });
        System.out.println(result);
    }
}
