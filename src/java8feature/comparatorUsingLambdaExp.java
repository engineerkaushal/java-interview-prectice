package java8feature;

import java.util.*;

public class comparatorUsingLambdaExp {
    public static void main(String[] args) {
        // Using List
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(1);
        list.add(99);
        list.add(76);
        //Collections.sort(list, (a,b) -> b -a);
        Collections.reverse(list);
        System.out.println(list);

        // Using Set
        Set<Integer> set = new TreeSet<>();
        set.add(22);
        set.add(1);
        set.add(13);
        System.out.println("Before manual sorting :" + set);
        Set<Integer> ss = new TreeSet<>((a, b) -> b - a);
        ss.add(22);
        ss.add(1);
        ss.add(13);
        System.out.println("After manual sorting :" + ss);

        // Using Map
        Map<Integer, String> mp = new TreeMap<>();
        mp.put(2, "z");
        mp.put(3, "f");
        mp.put(1, "y");
        System.out.println("Before manual sorting :" + mp);
        Map<Integer, String> mm = new TreeMap<>((a, b) -> b - a);
        mm.put(2, "z");
        mm.put(3, "f");
        mm.put(1, "y");
        System.out.println("After manual sorting :" + mm);

        Student s1 = new Student(2, "Kaushal");
        Student s2 = new Student(3, "Saurabh");
        Student s3 = new Student(33, "Anu");
        List<Student> lst = new ArrayList<>();
        lst.add(s1);
        lst.add(s2);
        lst.add(s3);
        Collections.sort(lst, (a, b) -> b.id - a.id );
        System.out.println(lst);
    }
}
