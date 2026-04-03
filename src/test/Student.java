package test;

import java.util.HashMap;
import java.util.Map;

class StudentDetails {
    private String name;
    private String course;
    private int id;
    public StudentDetails (String name, String course, int id) {
        this.name = name;
        this.course = course;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", id=" + id +
                '}';
    }
}
public class Student {
    public static void main(String[] args) {
        StudentDetails sd1 = new StudentDetails("ABC", "Math", 1);
        StudentDetails sd2 = new StudentDetails("DEF", "Bio", 2);
        StudentDetails sd3 = new StudentDetails("GHI", "Comm", 3);
        Map<StudentDetails, Object> map = new HashMap<>();
        map.put(sd1, "value1");
        map.put(sd2, "value2");
        map.put(sd3, "value3");
        System.out.println(map);
    }
}
