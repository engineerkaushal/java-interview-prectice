package InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewQ13 {
    public static void main(String[] args) {

        Map<String, Double> employeeSalary = new HashMap<>();
        employeeSalary.put("Alice", 75000.0);
        employeeSalary.put("Bob", 55000.0);
        employeeSalary.put("Charlie", 65000.0);
        employeeSalary.put("David", 55000.0);
        employeeSalary.put("Eve", 75000.0);

        List<EmployeeDetails> employeeDetails = EmployeeDetails.getDummyEmployees();

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<String, String> stringMap = employeeDetails.stream()
                .filter(f -> f.getId() % 2 != 0)
                .collect(Collectors.toMap(EmployeeDetails::getName, e -> String.valueOf(e.getId())
                        , (n1, n2) -> "[" + n1 + ", " + n2 + "]"));

        System.out.println(stringMap);
        System.out.println("-----------------------------------------------------------1----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        LinkedList<EmployeeDetails> linkedList = employeeDetails.stream()
                .sorted(Comparator.comparing(EmployeeDetails::getName).thenComparing(EmployeeDetails::getId))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(linkedList);
        System.out.println("-----------------------------------------------------------2----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<List<String>, String> listMap = employeeDetails.stream()
                .collect(Collectors.toMap(EmployeeDetails::getSkills, EmployeeDetails::getName, (a,b) -> a + "," + b));

        System.out.println(listMap);
        System.out.println("-----------------------------------------------------------3----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<String, List<String>> map = employeeDetails.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getName
                        , Collectors.mapping(EmployeeDetails::getDepartment, Collectors.toList())));

        map.forEach((a, b) -> System.out.println(a + " : " + b));
        System.out.println("-----------------------------------------------------------4----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<String, Long> longMap = employeeDetails.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment, Collectors.counting()));

        System.out.println(longMap);
        System.out.println("-----------------------------------------------------------5----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<String, List<String>> listMap1 = employeeDetails.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment
                        , Collectors.mapping(EmployeeDetails::getName, Collectors.toList())));

        System.out.println(listMap1);
        System.out.println("-----------------------------------------------------------6----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<Double, List<String>> collect = employeeDetails.stream()
                .sorted(Comparator.comparing(EmployeeDetails::getSalary).reversed())
                .collect(Collectors.groupingBy(EmployeeDetails::getSalary, LinkedHashMap::new
                        , Collectors.mapping(EmployeeDetails::getName, Collectors.toList())));

        List<Map.Entry<Double, List<String>>> collect1 = collect.entrySet().stream().collect(Collectors.toList());

        System.out.println(collect1.get(0));
        System.out.println("-----------------------------------------------------------7----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        List<EmployeeDetails> employeeDetail = employeeDetails.stream()
                .sorted(Comparator.comparing(EmployeeDetails::getName)
                        .thenComparing(Comparator.comparingDouble(EmployeeDetails::getSalary).reversed()))
                .collect(Collectors.toList());

        System.out.println(employeeDetail);
        System.out.println("-----------------------------------------------------------8----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Map<String, Double> doubleMap = employeeSalary.entrySet().stream()
                .sorted((e1, e2) -> {
                    int compare = e2.getValue().compareTo(e1.getValue());
                    return compare != 0 ? compare : e1.getKey().compareTo(e2.getKey());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        System.out.println(doubleMap);
        System.out.println("-----------------------------------------------------------9----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        List<Double> list = employeeSalary.values().stream().distinct().collect(Collectors.toList());
        System.out.println(list);
        System.out.println("-----------------------------------------------------------10----------------------------------------------------------");


        List<String> stringList = employeeSalary.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(stringList);
        System.out.println("-----------------------------------------------------------11----------------------------------------------------------");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        Map<String, List<Double>> map1 =
                Optional.ofNullable(employeeDetails)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(e -> e.getDepartment() != null)
                        .collect(Collectors.groupingBy(
                                EmployeeDetails::getDepartment,
                                Collectors.mapping(EmployeeDetails::getSalary, Collectors.toList())
                        ));

        System.out.println(map1);


        Map<String, Double> nThHeighestSalary = getNthHeighestSalaryDepartmentWiseFromListOfEmployees(employeeDetails, 1);
        System.out.println(nThHeighestSalary);
        System.out.println("-----------------------------------------------------------12----------------------------------------------------------");
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        Map<String, Double> map2 = Optional.ofNullable(employeeDetails)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment,
                        Collectors.collectingAndThen(Collectors.mapping(EmployeeDetails::getSalary, Collectors.toSet()),
                                empSalary -> empSalary.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null))));

        System.out.println("Dep wise salary : " + map2);
    }

    public static Map<String, Double> getNthHeighestSalaryDepartmentWiseFromListOfEmployees(List<EmployeeDetails> employeeDetails, int nThHeighestSalary) {
        Map<String, List<Double>> map1 =
                Optional.ofNullable(employeeDetails)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(e -> e.getDepartment() != null)
                        .collect(Collectors.groupingBy(
                                EmployeeDetails::getDepartment,
                                Collectors.mapping(EmployeeDetails::getSalary, Collectors.toList())
                        ));

        return map1.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                    .sorted(Comparator.reverseOrder())
                                    .skip(nThHeighestSalary)
                                    .findFirst()
                                    .orElse(0.0)

                ));
    }
}
