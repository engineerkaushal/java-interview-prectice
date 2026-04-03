package OOPS;
class StudentInfo {
    String name;
    int age;
    // Complie time polymorphism
    // function overloading -> same function name with different return type or different type of paramente
    public  void info(String name) {
        System.out.println("Student name is :" + name);
    }
    public  void info(int age) {
        System.out.println("Student age is: "+ age);
    }

    public  void info(String name, int age) {
        System.out.println("Name & age of Student is : " + name + " " + age);
    }

}

public class Polymorphism {
    public static void main(String[] args) {
        StudentInfo si = new StudentInfo();
        si.name = "Saurabh";
        si.age = 24;
        si.info(si.name);
    }
}
