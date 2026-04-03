package jocata;
interface sum{
    // we can override default method
    default Integer sum2No(int a, int b){
        return a+b;
    }
    // we can't override static method
    static Integer sub2no (int a, int b){
        return b-a;
    }
}
public class defaultAndStaticMethodInJava8Feature implements sum {
    public static void main(String[] args) {
        defaultAndStaticMethodInJava8Feature lambdaExp = new defaultAndStaticMethodInJava8Feature();
        System.out.println(lambdaExp.sum2No(2, 5));
        System.out.println(sum.sub2no(2, 5));

    }

    @Override
    public Integer sum2No(int a, int b) {
        return 9;
    }

}
