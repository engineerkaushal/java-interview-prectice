package InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InterviewQ_27_UpperCase_of_First_nth_or_Last_nth {
    public static void main(String[] args) {
        String input = "Kaushal Sin";
        System.out.println(upperCaseMethod(input, 2));
    }

    public static String upperCaseMethod(String input, int noOfUpperCase) {
        StringBuilder sb = new StringBuilder();
        if (input.trim().contains(" ")) {
            String[] split = input.split(" ");
            Arrays.stream(split).forEach( value -> {
                sb.append(value.substring(0, value.length() - noOfUpperCase)
                        + value.substring(value.length() - noOfUpperCase).toUpperCase()).append(" ");
            });
        } else {
            sb.append(input.substring(0, input.length() - noOfUpperCase)
                    + input.substring(input.length() - noOfUpperCase).toUpperCase()).append(" ");
        }
        return sb.toString().trim();
    }
}
