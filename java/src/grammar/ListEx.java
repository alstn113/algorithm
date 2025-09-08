package grammar;

import java.util.*;

public class ListEx {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        // 요소 추가
        list1.add("a");
        list1.add("b");

        // 길이
        System.out.println(list1.size()); // 1

        // 특정 인덱스에 추가
        list1.add(1, "b");

        // 특정 인덱스 요소 수정
        list1.set(1, "c");

        // 특정 인덱스 요소 반환
        System.out.println(list1.get(1)); // c

        // 특정 요소의 첫 번째 인덱스
        System.out.println(list1.indexOf("c")); // 1

        // 특정 요소의 마지막 인덱스
        System.out.println(list1.lastIndexOf("b")); // 2

        // 요소 삭제
        list1.remove(0);
        // 숫자 요소 삭제 시 - remove int면 인덱스, Integer면 값
        // list1.remove(Integer.valueOf(1));

        // 요소 비우기
        // list1.clear();

        // 리스트가 비어있는지 확인
        System.out.println(list1.isEmpty()); // false

        // 요소 순회
        for (String str : list1) {
            System.out.println(str);
        }

        // 요소 포함 여부
        System.out.println(list1.contains("a")); // true

        // 요소가 모두 포함되어 있는지 확인
        System.out.println(list1.containsAll(list2)); // true

        // 람다식을 이용한 삭제
        list1.removeIf(str -> str.equals("b"));
    }
}
