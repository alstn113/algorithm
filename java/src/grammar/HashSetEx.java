package grammar;

import java.util.HashSet;

public class HashSetEx {

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        // 합집합
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // 교집합
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // 차집합
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        // 보유 여부
        System.out.println(set1.contains(1)); // true

        // 요소 개수
        System.out.println(set1.size()); // 3

        // 요소 비우기
        // set1.clear();

        // 요소 삭제
        set1.remove(1);

        // 요소 순회
        for (Integer i : set1) {
            System.out.println(i);
        }
    }
}
