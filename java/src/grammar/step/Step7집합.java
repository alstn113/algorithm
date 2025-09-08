package grammar.step;

import java.util.HashSet;
import java.util.Set;

public class Step7집합 {

    public static void main(String[] args) {
        // 집합(Set) : 중복을 허용하지 않는 데이터 구조
        // add, remove, clear, size, contains

        // set1.addAll(set2) : 합집합
        // set1.removeAll(set2) : 차집합
        // set1.retainAll(set2) : 교집합

        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("kiwi");

        System.out.println(set.contains("apple")); // true
        System.out.println(set.size()); // 3
    }
}
