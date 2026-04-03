package fundamental;

abstract class AB {
    String name;
    int age;
    public AB() {
    }
    public AB(String name) {
        this.name = name;
        this.age = 29;
    }
    abstract void sum();
    void add() {
        System.out.println("abstract A");
    }
}

class BC extends AB {

    @Override
    void sum() {
        System.out.println("override abstract method from abstract class A to class B");
    }

    @Override
    void add() {
        System.out.println("B");
    }
}
public class AbstractClass {

    public static void main(String[] args) {
        AB c = new BC();
        c.add();
        c.sum();
        System.out.println(c.age + " " + c.name);
    }
}
