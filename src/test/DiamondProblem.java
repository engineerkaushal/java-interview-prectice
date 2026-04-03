package test;
interface A {
    //void save();
    default void print() {
        System.out.println("A");
    }
}
interface B extends A {
    //void save();
    default void print() {
        System.out.println("B");
    }
}
interface C extends A {
    //void save();
    default void print() {
        System.out.println("C");
    }
    
}

class D implements B, C {
    @Override
    public void print() {
        B.super.print();
    }


    /*@Override
    public void save() {
        System.out.println("Hi");
    }*/
}

class AB {
    void a() {
        System.out.println("AB");
    }
}
class BC extends AB {
    void a() {
        System.out.println("BC");
    }
}

class CD extends AB {
    void a() {
        System.out.println("CD");
    }
}

public class DiamondProblem {
    public static void main(String[] args) {
        D d = new D();
        //d.save();
        d.print();

    }
}
