package OOPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//1. public -> accessible from anywhere
//2. Protacted -> accessible within the same package and subclass
//3. Private -> Accessible only within the declared class
//4. default -> Accessible within the same package
class Account{
    public String name;
    String collegeName;
    private String customerName;
    protected String designation;
}
public class AccessModifiers {
    public static void main(String[] args) {
        AccessModifiers am = new AccessModifiers();
        am.check();

    }

    public void check () {
        try {
            System.out.println("Try");
        } finally {
            System.out.println("Finally");
        }
    }
}
