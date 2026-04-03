package java8FeaturePracticeCode;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String city;
    private Integer age;

    public Employee(String empName, String cityName, Integer age) {
        this.name = empName;
        this.city = cityName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
public class java8Practice {
    public static void main(String[] args) {


        // odd even number
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        integers = integers.stream().filter(f -> f % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(integers);

        // camel case
        List<String> calelCase;
        List<String> lst = Arrays.asList("Saurabh Kingh","Sumit raja","Kaushal","Shivani singh");
        calelCase = lst.stream().filter(m -> String.valueOf(m.charAt(0)).equalsIgnoreCase("s") && m.contains(" "))
                .map(m -> m.split(" ")[0].toLowerCase()
                        + String.valueOf(m.split(" ")[1].charAt(0)).toUpperCase()
                        + m.split(" ")[1].substring(1)).collect(Collectors.toList());
        System.out.println(calelCase);


        // first char of list of string
        List<String> charList;
        charList = lst.stream().map(m -> String.valueOf(m.charAt(0)).toLowerCase()).collect(Collectors.toList());
        System.out.println(charList);

        //Given a list of words and another string word. find all string in list which have the same characters as string word
        List<String> stdName = Arrays.asList("kanak", "subida", "nakna", "aanak", "Kaushal", "Aditya");
        StringBuilder sb = new StringBuilder();
        String name = "kanak";
        char[] sName = name.toCharArray();
        Arrays.sort(sName);
        List<String> addStd = new ArrayList<>();
        stdName.stream().filter(f -> f.length() == sName.length).forEach(v -> {
            char[] lstOfCh = v.toCharArray();
            sb.append(sName);
            Arrays.sort(lstOfCh);
            sb.append(lstOfCh);
            if (sb.append(sName).toString().equalsIgnoreCase(sb.toString()))
                addStd.add(v);
        });
        System.out.println(addStd);



        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Kaushal", "Hyderabad", 29));
        employees.add(new Employee("Saurabh", "Noida", 24));
        employees.add(new Employee("Shivani", "Sasaram", 29));
        employees.add(new Employee("Rajat", "Noida", 28));
        employees.add(new Employee("Abhishek", "Mumbai", 28));

        // List
        List<String> employees1 = employees.stream()
                .filter(f -> f.getCity().equalsIgnoreCase("Noida"))
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println("List -> " + employees1);

        //Map
        Map<String, String> mp = employees.stream()
                .filter(f -> f.getCity().equalsIgnoreCase("Noida"))
                .collect(Collectors.toMap(Employee::getName, Employee::getCity));

        Map<String, String> mp1 = employees.stream()
                .filter(f -> f.getCity().equalsIgnoreCase("Noida"))
                .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getCity()));
        System.out.println("Map -> " + mp);

        // single group
        Map<Integer, List<Employee>> gp = employees.stream()
                .filter(f -> f.getAge()== 29)
                .collect(Collectors.groupingBy(g -> g.getAge()));
        System.out.println(gp);

        // Inner group
        Map<Integer, Map<String, List<Employee>>> list;
        Map<Integer, Map<String, List<Employee>>> gp1 = employees.stream()
                .filter(f -> f.getAge()== 29)
                .collect(Collectors.groupingBy(g -> g.getAge(), Collectors.groupingBy(g -> g.getCity())));
        /*gp1.forEach((age, cityGroup) -> {
            cityGroup.forEach((city, nameGroup) -> {
                nameGroup.forEach(empName -> System.out.println(age+"={"+city+ "=["+ empName.getName()+"]}"));
            });
        });*/
        System.out.println(gp1);


        // Frequency of each char of given String using java8
        Map<Character, Integer> frequency = new HashMap<>();
        String myName = "Kakakakakakausuhuall";
        Map<Character, Long> result = myName.toUpperCase().chars()
                .mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String s1 = Arrays.stream(myName.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(f -> f.getValue() > 1).findFirst().get().getKey();
        System.out.println(s1);


        // Frequency of each char of given String using Java Traditional Approach
        for(char c : myName.toUpperCase().toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        frequency.forEach((ch, f) -> System.out.println("Character: "+ch+", frequency: " + f));
        //System.out.println(frequency);

        // avoid duplicate value
        List<Integer> value = Arrays.asList(1,1,2,2,3,4,5,6,6,7,8,9,9);
        List<Integer> filteredValue = new ArrayList<>();
        Map<Integer, Long> filteredValue1;
        filteredValue1 = value.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        filteredValue1.forEach((k, v) -> {
            if (v == 1) {
                filteredValue.add(k);
            }
        });

        List<Integer> integerList = value.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f -> f.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(integerList);



        /*String valueStr = " kaushalsdshsinghddixithh ";
        String husband = "";
        if (valueStr != null && valueStr.trim().length() > 20) {
            if (valueStr.trim().contains(" ")) {
                String[] spltValue = valueStr.trim().split(" ");
                if (spltValue.length == 2) {
                    husband = spltValue[0].charAt(0) + " " + spltValue[1];
                } else if (spltValue.length > 2) {
                    for (int i = 2; i < spltValue.length; i++) {
                        husband = spltValue[0].charAt(0) + " " + spltValue[1].charAt(0)+ " " + spltValue[i] + " ";
                    }
                }

                    System.out.println(husband.trim());
            } else {
                System.out.println(valueStr.trim());
            }
        }*/

        //
        List<String> lst1 = Arrays.asList("Kaushal", "Saurbah","Anu", "kk9", "!sac9");
        String s = "Kaushal Singh Dixit        Saurabh Anu kk9 !sac9";
        List<String> s2 = Arrays.asList(s.split("\\s+"));
        System.out.println(s2);
        /*Map<String, String> rlt = s2.stream().collect(Collectors.toMap(m -> m, m -> containsNoSpecialChars(m) ? "Yes" : "No"));
        System.out.println(rlt);*/
        s2.forEach(v -> System.out.println(v + (containsNoSpecialChars(v) ? ": Yes" : ": No")));
    }

    public static boolean containsNoSpecialChars(String input) {
        boolean result = false;
        // Regex: ^[a-zA-Z0-9_ ]*$ means letters, digits, space, and underscore are allowed
        if (input.matches("^[a-zA-Z0-9]*$")) {
            if (input.trim().length() > 2) {
                String s1;
                String s2;
                s1 = input.replaceAll("[^aeiouAEIOU]", "");
                s2 = input.replaceAll("[^b-df-hj-np-tv-zBF-HJ-NP-TV-Z]", "");
                if (!s1.isEmpty() && !s2.isEmpty()) {
                    result = true;
                }
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }


}
