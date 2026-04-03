package jocata;
interface SuperType {
    void test();
}
class DefultSuperType implements SuperType {

    @Override
    public void test() {
        System.out.println("0");
    }
}

class ChildSuperClass extends DefultSuperType {
    @Override
    public void test() {
        System.out.println("1");
    }
}
public class TestClass {
    public static void main(String[] args) {
        SuperType superType = new ChildSuperClass();

        DefultSuperType ds = (DefultSuperType) superType;
        ds.test();
        System.out.println("End");
    }
}
