package java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        // write a fuction to return string length
        Function<String, Integer> f = len -> len.length();
        System.out.println("Length is :" + f.apply("Kaushal"));

        Function<String, Integer> fun1 = len -> len.length();
        Function<String, String> fun2 = len -> len.substring(0, 3);
        Function<List<Student>, List<Student>> listOfStudent = list -> {
            List<Student> studentList = new ArrayList<>();
            for (Student s: list) {
                if (fun2.apply(s.getName()).equalsIgnoreCase("Kau")) {
                    studentList.add(s);
                }
            }
            return studentList;
        };
        Student s1 = new Student(1, "Kaushal");
        Student s2 = new Student(2, "Kaushik");
        Student s3 = new Student(3, "Saurabh");
        List<Student> list = Arrays.asList(s1, s2, s3);
        List<Student> studentList = listOfStudent.apply(list);
        System.out.println(studentList);

    }
    private static class Student{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
