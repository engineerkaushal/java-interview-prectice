package fundamental;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class A {
    void print() throws Exception {
        System.out.println("A");
    }
    static void add() {
        System.out.println("Static A");
    }
}
class B extends A {

    @Override
    void print(){
        System.out.println("B");
    }

    public static void add() {
        System.out.println("Static B");
    }
}

public class t1 {
    public static void main(String[] args) throws Exception {
        A a1 = new B();
        A a = new A();
        B b = (B) a1;

        a1.print();
        A.add();

        a.print();
        A.add();

        b.print();
        B.add();

        int i = 1;
        int j = 2;
        int sum = i + j;
        String s1 = new String("abc");
        String s2 = "abc";
        /*List list = new ArrayList();
        list.add("a");
        list.add("b");*/
        System.out.println(s1.hashCode() + "==" +s2.hashCode());
        System.out.println(s1==s2);

        List<Integer> list = IntStream.rangeClosed(100, 200)
                .filter(f -> IntStream.rangeClosed(2, (int) Math.sqrt(f)).noneMatch(p -> f % p == 0))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(list);


        IntStream.rangeClosed(100, 200).forEach(value -> {
            for (int k = 2; k <= value/2; k++) {
                if (value % k == 0)
                    return;
            }
            System.out.println(value);
        });


    }
}
