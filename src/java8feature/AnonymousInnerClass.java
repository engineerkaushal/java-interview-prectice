package java8feature;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        // Anonymous inner class
        Employee emp = new Employee() {
            @Override
            public Integer getSalary() {
                return 100;
            }

            @Override
            public String getDesignation() {
                return "Software Engineer";
            }
        };
        System.out.println(emp.getSalary() + "\n" + emp.getDesignation());
    }
}
