package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ15_ReverseString {
    public static void main(String[] args) {

        String inputValue = "Kaushal";

        List<String> list = Arrays.asList("Kaushal", "Saurabh", "Anu", "Baby", "Shivani");

        //---------------------------------------------------------------
        List<String> list1 = list.stream()
                .map(m -> Arrays.stream(m.split("")).reduce("", (a, b) -> b + a))
                .collect(Collectors.toList());
        System.out.println("Using reduce() method in java 8 : " + list1);


        //---------------------------------------------------------------
        List<String> list2 = list.stream().map(m -> new StringBuilder(m).reverse().toString()).collect(Collectors.toList());
        System.out.println("Using StringBuilder() : " + list2);

        //--------------------------------------------------------------

        String revString = Arrays.stream(inputValue.split("")).reduce("", (a, b) -> b + a);
        System.out.println(revString);

        //--------------------------------------------------------------
        System.out.println(getReverseString(inputValue));

    }

    public static String getReverseString(String input) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = input.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
