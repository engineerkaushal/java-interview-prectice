package InterviewQuestions;

public class EmployeeBuilderClass {

    // 1. Private fields
    private int id;
    private String name;
    private String department;
    private double salary;

    public EmployeeBuilderClass() {}

    // 2. Private constructor (accepts builder)
    private EmployeeBuilderClass (BuilderVo builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.department = builder.department;
        this.salary = builder.salary;
    }

    /*public static BuilderVo builder() {
        return new BuilderVo();
    }*/

    // 3. Static nested Builder class
    public static class BuilderVo {
        private int id;
        private String name;
        private String department;
        private double salary;

        // "Setter" methods that return Builder (for chaining)
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        // 4. Build method to create the main object
        public EmployeeBuilderClass build() {
            return new EmployeeBuilderClass(this);
        }
    }
}
