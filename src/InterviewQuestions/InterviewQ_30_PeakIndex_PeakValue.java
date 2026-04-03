package InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class InterviewQ_30_PeakIndex_PeakValue {
    public static void main(String[] args) {
        int[] input = {2, 3, 4, 1, 2, 4};
        int target = 1;

        Integer peakValue = Arrays.stream(input)
                .boxed().max(Comparator.comparingInt(v -> v)).orElse(null);

        Integer peakIndex = IntStream.range(0, input.length).boxed()
                .max(Comparator.comparingInt(v -> input[v])).orElse(null);

        Integer index = IntStream.range(0, input.length)
                .boxed()
                .filter(f -> input[f] == target)
                .findFirst().orElse(null);

        System.out.println("Peak value : " + peakValue);
        System.out.println("Peak value index : " + peakIndex);
        System.out.println("Target value index : " + index);
    }
}
