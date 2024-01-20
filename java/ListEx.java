import java.util.ArrayList;
import java.util.List;

class ListEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 추가
        list.add("apple");

        // 길이
        System.out.println(list.size()); // 1

        // 특정 인덱스에 추가
        list.add(0, "banana"); // banana, apple

        // 특정 인덱스의 값 변경
        list.set(0, "orange"); // orange, apple

        // 특정 인덱스의 값 가져오기
        System.out.println(list.get(0)); // orange

        // 특정 값의 인덱스 가져오기
        System.out.println(list.indexOf("apple")); // 1

        // 특정 요소의 마지막 인덱스 가져오기
        list.add("apple");
        System.out.println(list.lastIndexOf("apple")); // 2

        // 특정 인덱스의 값 삭제
        list.remove(0); // apple

        // 특정 값 삭제
        list.remove("apple"); // apple

        // 리스트 비우기
        list.clear();

        // 리스트가 비어있는지 확인
        System.out.println(list.isEmpty()); // true

        // 리스트 복사
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list2.addAll(list); // apple, banana, orange

        // 리스트 교집합
        list.retainAll(list2); // apple, banana, orange

        // 리스트 차집합
        list.removeAll(list2); // apple, banana, orange

        // 리스트 순회
        for (String s : list) {
            System.out.println(s);
        }

        // 리스트가 특정 값을 포함하는지 확인
        System.out.println(list.contains("apple")); // true

        // 리스트에 다른 리스트 요소가 전부 포함되는지 확인
        System.out.println(list.containsAll(list2)); // true

        // 람다식 사용하여 요소 삭제
        list.removeIf(s -> s.equals("apple")); // banana, orange
    }
}
