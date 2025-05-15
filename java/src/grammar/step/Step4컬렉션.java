package grammar.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Step4컬렉션 {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(temp)
                .boxed()
                .toList();

        Collections.max(list); // 최대값
        Collections.min(list); // 최소값

        // 정렬
        Collections.sort(list); // 오름차순 정렬
        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

        // 2차원 리스트 정렬
        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(list);
        list2.add(list);
        Collections.sort(list2, (o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });

        // 빈도
        List<String> list3 = new ArrayList<>();
        list3.add("apple");
        list3.add("banana");
        list3.add("apple");
        Collections.frequency(list3, "apple"); // apple의 빈도수
    }
}
