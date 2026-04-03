package OOPS;
class Pen
{
    String type;
    String color;
    public void write() {
        System.out.println("Write something");
    }
    public void printColor() {
        System.out.println(this.color);
        //this key word identify that those method which object is trying to access
    }
}

class Student {
    String name;
    Integer age;

    public void printInfo() {
        System.out.println(this.name + " " + this.age);
    }

    //1. NonParamerized Constructor
    Student() {
        System.out.println("Non Parameterized Constructor called");
    }
    // 2. Parameterized Constructor
    Student(String studentName, int studentAge) {
        this.name = studentName;
        this.age = studentAge;
    }

    public void parameterizedInfo() {
        System.out.println("Parameterized Constructor Info: "+this.name + " " + this.age);
    }
    // 3. Copy constructor
    Student(Student s1) {
        this.name = s1.name;
        this.age = s1.age;
    }
    public void copyConstructorInfo() {
        System.out.println("Copy Constructor Info: "+this.name + " " + this.age);
    }
}

public class ObjectAndClass {
    public static void main(String args[]) {
        Pen p = new Pen();// Pen() is a specail type of function called constructor.
        // under Java, three type of constructor ->
        //1. non paramererized constructor 2. paramerized 3. copy constructor
        //Properties of Constructor:
        // 1.Name of constructor same as Class name
        //2.Constructor is nothing but method or function but will not return, It will construct only object
        // 3. for one object, constructor will call only one time while creating object
        // use of new keyword: once we use new keyword, under memory heap one space will be allocate and all the object
        // will be store
        p.color = "red";
        p.type = "Ball Pen";
        p.write();
        p.printColor();

        Pen p1 = new Pen();
        p1.color = "Blue";
        p1.printColor();


        Student s = new Student();
        s.age = 24;
        s.name = "Saurabh";
        s.printInfo();

        // Parameterized constructor object
        Student s1 = new Student("Kaushal", 25);
        s1.parameterizedInfo();

        // copy constructor object
        Student s2 = new Student();
        s2.name = "Ram";
        s2.age = 20;
        Student s3 = new Student(s2);
        s3.copyConstructorInfo();

    }
}
