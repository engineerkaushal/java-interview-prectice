package fundamental;

import java.util.LinkedHashMap;
import java.util.Map;

public class T2 {
    public static void main(String[] args) {
        Map<String, Integer> v = new LinkedHashMap<>();
        v.put("A", 1);
        v.put("B", 2);
        v.put("C", 3);
        v.put("B", 4);
        v.put("D", 5);

        System.out.println(v);
    }
}
