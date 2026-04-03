package java8feature;

public class LambdaExp {
    public static void main(String[] args) {
        functionalInterface fi = (a, b) -> a + b;
        System.out.println(fi.sum(1, 8));
    }
}
