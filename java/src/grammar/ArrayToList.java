package grammar;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToList {

    public static void main(String[] args) {

        // Array
        String[] arr1 = { "a" , "b", "c"};

        // List
        List<String> list = new ArrayList<>(Arrays.asList(arr1));

        // List -> Array
        String[] arr2 = list.toArray(String[]::new);

        // List, Array -> Join
        String str1 = String.join(", ", list);
        String str2 = String.join(", ", arr2);

        System.out.println(str1); // a, b, c
        System.out.println(str2); // a, b, c

        // String -> Split
        String[] split = str1.split(", ");

        List<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        int[] arr3 = {1, 2, 3};
        // List -> Array
        List<Integer> list3 = Arrays.stream(arr3).boxed().collect(Collectors.toList());

        // Array -> List
        int[] arr4 = list3.stream().mapToInt(i -> i).toArray();
    }
}