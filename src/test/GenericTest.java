package test;

//TODO: Generic class
class Generic1<T>{
    private T name;
    private T age;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}

//TODO: Generic Constructor with Generic class
class Generic2<T> {
    private T name;
    private T age;

    public Generic2(T name, T age) {
        this.name=name;
        this.age=age;
    }
}

//TODO: Generic Constructor without Generic class
class Generic3 {
    private String name;
    private int age;

    public <T> Generic3(T name, T age) {
        /*this.name = (String) name;
        this.age = (int) age;*/
    }
}

//TODO: Generic interface
interface GenericInterface {
    <T> void add(T details);

    default <T> T getData(T id) {
       return id;
    }
    static <T> void save(T entity) {
    }
}


public class GenericTest {
    public static void main(String[] args) {
        Generic1 gn = new Generic1();
        gn.setName("Kaushal Singh");
        gn.setAge(30);

        System.out.println(gn.getName() + " : " + gn.getAge());
    }
}
