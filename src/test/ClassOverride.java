package test;
enum Eclass{
    ;
    Eclass() {
        System.out.println();
    }
}
class Animal {
     void sound() {
        System.out.println("Animal makes a sound in Parent class");
    }
}
class Dog extends Animal{
    void sound() {
        System.out.println("Dog barks in child class");
    }
}

public class ClassOverride {

    public static void main(String[] args) {
        // Up Casting: Upcasting happens here when a Dog object is assigned to an Animal reference variable (Animal animal = new Dog();).
        Animal animal = new Dog();
        animal.sound();

        // Down Casting: Dog dog = (Dog) animal; — The Animal reference (animal) is explicitly downcasted to a Dog reference so that you can access Dog-specific methods.
        Dog dog = (Dog) animal;
        dog.sound();
    }
}
