package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewQ3_Prime {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        // Approach 1
        numbers = numbers.stream()
                .filter(f -> f > 1 && IntStream.rangeClosed(2, f/2) // instead of f/2 also we can use Math.sqrt(f)
                        .noneMatch(i -> f % i == 0))
                .collect(Collectors.toList());
        System.out.println("Approach 1 : " + numbers);

        // Approach 2
        numbers = numbers.stream()
                .filter(InterviewQ3_Prime::isPrime)
                .collect(Collectors.toList());
        System.out.println("Approach 2 : " + numbers);
    }

    // Part of Approach 2
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
