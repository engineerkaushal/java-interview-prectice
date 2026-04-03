package InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewQ14_KeypadMobile {
    private static final Map<String, String> keypadMap = new HashMap<>();
    static {
        keypadMap.put("A", "2");keypadMap.put("B", "2");keypadMap.put("C", "2");
        keypadMap.put("D", "3");keypadMap.put("E", "3");keypadMap.put("F", "3");
        keypadMap.put("G", "4");keypadMap.put("H", "4");keypadMap.put("I", "4");
        keypadMap.put("J", "5");keypadMap.put("K", "5");keypadMap.put("L", "5");
        keypadMap.put("M", "6");keypadMap.put("N", "6");keypadMap.put("O", "6");
        keypadMap.put("P", "7");keypadMap.put("Q", "7");keypadMap.put("R", "7");keypadMap.put("S", "7");
        keypadMap.put("T", "8");keypadMap.put("U", "8");keypadMap.put("V", "8");
        keypadMap.put("W", "9");keypadMap.put("X", "9");keypadMap.put("Y", "9");keypadMap.put("Z", "9");
        keypadMap.put(" ", "0");

    }

    public static void main(String[] args) {
        String input = "Kaushal";
        System.out.println(getKeypadResult(keypadMap, input));
    }

    public static String getKeypadResult(Map<String, String> keypadMap, String input) {
        return input.toUpperCase().chars()
                .mapToObj(m -> String.valueOf((char) m))
                .filter(f -> keypadMap.containsKey(f))
                .map(m -> keypadMap.get(m)).collect(Collectors.joining());
    }
}
