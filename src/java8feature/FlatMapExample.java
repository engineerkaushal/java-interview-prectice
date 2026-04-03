package java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee1 {
    private String name;
    private List<String> skills;

    public Employee1(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }
}
public class FlatMapExample {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1("Kaushal", Arrays.asList("Java", "Spring", "SQL")),
                new Employee1("Saurabh", Arrays.asList("Python", "Django")),
                new Employee1("Aman", Arrays.asList("JavaScript", "React"))
        );

        // ✅ FlatMap to extract all skills from all employees
        List<String> allSkills = employees.stream()
                .flatMap(emp -> emp.getSkills().stream())
                .collect(Collectors.toList());

        System.out.println("All Skills: " + allSkills);
    }
}
