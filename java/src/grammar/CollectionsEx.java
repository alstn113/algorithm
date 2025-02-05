package grammar;

import java.util.*;

public class CollectionsEx {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // min, max
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));

        // sort - ASC
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3]

        // reverse
        Collections.reverse(list);
        System.out.println(list); // [3, 2, 1]

        // frequency
        list.add(2);
        System.out.println(Collections.frequency(list, 2)); // 2

        // fill
        Collections.fill(list, 0);
        System.out.println(list); // [0, 0, 0, 0]
    }
}
