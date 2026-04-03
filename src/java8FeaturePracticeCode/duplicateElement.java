package java8FeaturePracticeCode;

import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface filterDuplicateElement{
    List<String> filterElement(List<String> request);
    default  List<String> filterElementWithList(List<String> request){
        List<String> response;
        response = request.stream().filter(f -> Collections.frequency(request, f) > 1).distinct().collect(Collectors.toList());
        return response;
    }

    default  Set<String> filterElementWithSet(List<String> request){
        Set<String> response = new HashSet<>();
        Set<String> finalResponse = response;
        response = request.stream().filter(f -> !finalResponse.add(f)).collect(Collectors.toSet());
        return response;
    }
}
public class duplicateElement/* implements filterDuplicateElement*/ {
    public static void main(String[] args) {
        duplicateElement de = new duplicateElement();
        List<String> list = new ArrayList<>();
        list.add("Kaushal");
        list.add("Saurabh");
        list.add("Shivani");
        list.add("Kaushal");
        list.add("Anu");
        list.add("Shivani");
        /*System.out.println(de.filterElementWithList(list));
        System.out.println(de.filterElementWithSet(list));*/
        filterDuplicateElement ele = x -> x.stream().filter(f -> Collections.frequency(x, f) > 1).distinct().collect(Collectors.toList());
        System.out.println(ele.filterElement(list));

    }
}
