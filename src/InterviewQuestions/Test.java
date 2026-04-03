package InterviewQuestions;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<EmployeeDetails> detailsList = EmployeeDetails.getDummyEmployees();

        Map<String, Double> doubleMap = Optional.ofNullable(detailsList)
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.groupingBy(EmployeeDetails::getDepartment,
                        Collectors.collectingAndThen(Collectors.mapping(EmployeeDetails::getSalary,
                                Collectors.toSet()), emp -> emp.stream().skip(1).findFirst().orElse(null))));

        System.out.println(doubleMap);

        detailsList.sort(Comparator.comparing(EmployeeDetails::getDepartment).thenComparing(EmployeeDetails::getSalary).reversed());

        List<String> strings = detailsList.stream().sorted(Comparator.comparing(EmployeeDetails::getDepartment))
                .collect(Collectors.mapping(EmployeeDetails::getDepartment, Collectors.toList()));

        detailsList.forEach(v -> {System.out.println(v.getDepartment() + " : " + v.getSalary());});

        Map<String, Double> value = new HashMap<>();
        value.put("Kaushal", 100000.0);
        value.put("Saurabh", 100000.0);
        value.put("Anu", 110000.0);
        value.put("Shivani", 120000.0);
        value.put("Rajan", 130000.0);

        value.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .forEach(v -> System.out.println(v.getKey() + " : " + v.getValue()));

        List<String> strList = Arrays.asList("Kaushal", "Saurabh", "Rajan");
        List<String> collect = strList.stream().map(m -> m.chars().mapToObj(obj -> String.valueOf((char) obj)).reduce("", (a, b) -> b + a)).collect(Collectors.toList());

        System.out.println(collect);

        List<String> collect1 = strList.stream().map(m -> Arrays.stream(m.split("")).reduce("", (a, b) -> b + a)).collect(Collectors.toList());
        System.out.println(collect1);

        Map<String, Set<Double>> map = detailsList.stream().sorted(Comparator.comparing(EmployeeDetails::getSalary).reversed())
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment,
                        Collectors.mapping(EmployeeDetails::getSalary, Collectors.toCollection(LinkedHashSet::new))));

        System.out.println(map);

        Map<String, Double> collect2 = detailsList.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, obj -> obj.getValue()
                        .stream()
                        .map(EmployeeDetails::getSalary)
                        .filter(Objects::nonNull)
                        .sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(0.0)));

        System.out.println(collect2);


        Map<String, Double> result =
                detailsList.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDetails::getName,
                                Collectors.averagingDouble(EmployeeDetails::getSalary)
                        ))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                entry -> entry.getKey(),
                                entry -> entry.getValue(),
                                (a, b) -> a,
                                LinkedHashMap::new   // maintains sorted order
                        ));

        System.out.println(result);

        Map.Entry<String, Double> collect3 = detailsList.stream().filter(f -> f.getName() != null && f.getSalary() != 0)
                .collect(Collectors.groupingBy(EmployeeDetails::getName, Collectors.averagingDouble(EmployeeDetails::getSalary)))
        .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).findFirst().orElse(null);

        System.out.println(collect3);

        Map<String, Double> collect4 = detailsList.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getName, Collectors.averagingDouble(EmployeeDetails::getSalary)));


    }

}
