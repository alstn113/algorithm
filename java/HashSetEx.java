import java.util.HashSet;

class HashSetEx {
    public static void main(String[] args) {
        // HashSet: 중복 허용 x, 순서 x
        // LinkedHashSet: 중복 허용 x, 순서 o (삽입순)
        // TreeSet: 중복 허용 x, 이진 검색 트리 형태로 저장, 정렬된 순서로 저장

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
        // set1 - set2
        difference.removeAll(set2);

        // 포함하는지 확인
        System.out.println(set1.contains(1)); // true

        // 비어있는지 확인
        System.out.println(set1.isEmpty()); // false

        // 길이
        System.out.println(set1.size()); // 3

        // 순회
        for (int i : set1) {
            System.out.println(i);
        }

        // 비우기
        set1.clear();

        // 제거
        set1.remove(1);
    }
}
