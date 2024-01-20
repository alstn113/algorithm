import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollectionsEx {
    public static void main(String[] args) {
        // 최소, 최대
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Collections.min(list)); // 1
        System.out.println(Collections.max(list)); // 3

        // 정렬
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3]

        // 뒤집기
        Collections.reverse(list);
        System.out.println(list); // [3, 2, 1]

        // 개수 반환
        list.add(1);
        System.out.println(Collections.frequency(list, 1)); // 2

        // 특정 값으로 채우기
        Collections.fill(list, 0); // 0, 0, 0, 0
    }
}
