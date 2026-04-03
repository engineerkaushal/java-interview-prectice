package java8feature;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Kaushal Singh";
        //reverse string using java8
        String s1 = IntStream.rangeClosed(1, s.length())
                .mapToObj(m -> s.charAt(s.length() - m))
                .map(m -> String.valueOf(m)).collect(Collectors.joining());
        System.out.println("reverse string using java8 : " + s1);

        // reverse string using traditional approach
        char[] c = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println("reverse string using traditional approach : " + sb.toString());

        // reverse string using StringBuilder
        StringBuilder sb1 = new StringBuilder(s);
        String s2 = sb1.reverse().toString();
        System.out.println("reverse string using StringBuilder : " + s2);
    }
}
