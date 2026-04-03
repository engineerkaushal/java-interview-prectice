package java8feature;
@FunctionalInterface
public interface functionalInterface{
    //Abstract method
    Integer sum(int a, int b);
    // default method
    default void sub() {

    }
    //Static method
    static Long compare() {
        return null;
    }
}
