package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewQ20_Fibonacci {
    public static void main(String[] args) {
        int input = 8;
        int a = 0, b = 1;
        //output: 0, 1, 1, 2, 3, 5, 8, 13
        List<Integer> output = new ArrayList<>();

        // Traditional for loop
        for (int i = 1; i <= input; i++) {
            output.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println(output);

        // using java 8
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}) // Starts with {0, 1} and computes the next Fibonacci pair {b, a+b}.
                .limit(input) // limits the stream to the desired number of elements.
                .map(f -> f[0]) // extracts the first element of each pair as the Fibonacci number.
                .collect(Collectors.toList());
        System.out.println(fibonacci);
    }
}
