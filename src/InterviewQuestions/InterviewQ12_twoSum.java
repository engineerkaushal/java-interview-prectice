package InterviewQuestions;


import java.util.*;

public class InterviewQ12_twoSum {

    public static void main(String[] args) {
        int[] lst = {2, 11, 8, 7, 13, 1};
        int target = 9;
        int[] result = getTwoSumResult(lst, target);
        System.out.println("["+result[0]+", "+result[1]+"]");

        System.out.println("----------------------------------");

        List<Integer> intList = Arrays.asList(2, 11, 8, 7, 13, 1);
        System.out.println(getTwoSumResultUsingList(intList, target));
    }

    //----------------------Using Array-------------------------
    public static int[] getTwoSumResult(int[] lst, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < lst.length; i++) {
            int comp = target - lst[i];
            if (store.containsKey(comp)) {
                return  new int[] {store.get(comp), i};
            }
            store.put(lst[i], i);
        }
        return lst;
    }
    //---------------------------End---------------------------

    // ------------------------------Using list---------------------------------------
    public static List<Integer> getTwoSumResultUsingList(List<Integer> lst, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < lst.size(); i++) {
            int comp = target - lst.get(i);
            if (store.containsKey(comp)) {
                result.add(store.get(comp));
                result.add(i);
                return result;
            }
            store.put(lst.get(i), i);
        }
        return lst;
    }
    //-------------------------------End---------------------------------------------
}
