package InterviewQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InterviewQ_23_Repeated_NonRepeated_Word {
    public static void main(String[] args) {
        String input = "Myam name amis Kmaushaml Singamh";
        String find = "am";

        //------------------------Using Java 8----------------------------
        long count = IntStream.range(0, input.length() - find.length() + 1)
                .filter(f -> input.substring(f, f + find.length()).equalsIgnoreCase(find))
                .count();

        System.out.println("Using Java 8 : " + count);

        //--------------------------Traditional Approach-----------------
        System.out.println("Using Traditional Approach : " + countOccurrencesTraditional(input, find));

    }

    public static int countOccurrencesTraditional(String input, String find) {
        int count = 0;
        int index = 0;

        while ((index = input.indexOf(find, index)) != -1) {
            count++;
            index = index + find.length();  // move ahead
        }
        return count;
    }
}
