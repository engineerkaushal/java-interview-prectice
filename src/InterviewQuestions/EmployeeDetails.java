package InterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class EmployeeDetails {
    private int id;
    private String name;
    private String department;
    private double salary;
    private List<String> skills;

    // Constructor
    public EmployeeDetails(int id, String name, String department, double salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    // Getters (optional setters भी add कर सकते हैं)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Employee { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                " }";
    }

    // Dummy Data Generator
    public static List<EmployeeDetails> getDummyEmployees() {
        return Arrays.asList(
                new EmployeeDetails(1, "AAAAA", "IT", 75000, Arrays.asList("Java", "Spring boot", "Hibernate", "SQL")),
                new EmployeeDetails(2, "BBBBB", "HR", 50000, Arrays.asList("Communication", "Recruitment")),
                new EmployeeDetails(3, "CCCCC", "Finance", 55000, Arrays.asList("Excel", "Accounting", "SAP")),
                new EmployeeDetails(4, "DDDDD", "IT", 80000, Arrays.asList("Python", "Docker", "Kubernetes")),
                new EmployeeDetails(5, "EEEEE", "Marketing", 65000, Arrays.asList("SEO", "Content Writing", "Analytics")),
                new EmployeeDetails(6, "FFFFF", "IT", 85000, Arrays.asList("Java", "Spring", "SQL")),
                new EmployeeDetails(7, "AAAAA", "HR", 55000, Arrays.asList("Communication", "Recruitment")),
                new EmployeeDetails(8, "GGGGG", "Finance", 65000, Arrays.asList("Excel", "Accounting", "SAP")),
                new EmployeeDetails(9, "BBBBB", "IT", 90000, Arrays.asList("Python", "Docker", "Kubernetes")),
                new EmployeeDetails(10, "HHHHH", "Marketing", 60000, Arrays.asList("SEO", "Content Writing", "Analytics"))
        );
    }

}
