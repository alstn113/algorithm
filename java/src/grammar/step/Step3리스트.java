package grammar.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Step3리스트 {

    public static void main(String[] args) {
        // 삽입
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add(0, "banana"); // 0번 인덱스에 "banana" 삽입
        list.addAll((List.of("kiwi", "mango"))); // 여러 개의 요소를 추가

        // 반환
        System.out.println(list); // [banana, apple, kiwi, mango]
        System.out.println(list.get(0)); // banana

        // list1.removeAll(list2) : list1에서 list2에 있는 모든 요소를 제거
        // list1.retainAll(list2) : list1에서 list2에 있는 요소만 남김

        // clear() : 리스트의 모든 요소를 제거
        // isEmpty() : 리스트가 비어있는지 확인
        // size() : 리스트의 크기를 반환
        // contains("a") : 리스트에 특정 요소가 포함되어 있는지 확인
        // containsAll(list2) : 리스트에 list2의 모든 요소가 포함되어 있는지 확인
        // list.removeIf(s -> s.equals("apple")); : 리스트에서 "apple"을 제거

        // 문자열 타입 배열을 리스트로 변환
        String[] strArray = {"apple", "banana", "kiwi"};
        List<String> strList = new ArrayList<>(Arrays.asList(strArray));

        // 리스트를 문자열 타입 배열로 변환
        String[] strArray2 = strList.toArray(String[]::new);

        // 정수 배열을 리스트로 변환
        int[] intArray = {1, 2, 3};
        List<Integer> intList = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList()); // 코딩테스트에서 toList()는 지원하지 않는 경우가 많음
        // int[]를 List<Integer>로 변환
        // 위는 불변, collect(Collectors.toList())는 가변

        // 정수 리스트를 배열로 변환
        int[] temp = intList.stream()
                .mapToInt(v -> v)
                .toArray();

        // 문자열 -> 문자 배열
        String str = "apple";
        char[] charArray = str.toCharArray(); // 문자열을 문자 배열로 변환
        String str2 = new String(charArray); // 문자 배열을 문자열로 변환

        // 문자열 리스트 -> 정수 리스트
        List<String> strList2 = List.of("1", "2", "3");
        List<Integer> intList2 = strList2.stream()
                .map(Integer::parseInt) // 문자열을 정수로 변환
                .toList(); // List<Integer>로 변환

        // 정수 리스트 -> 문자열 리스트
        List<Integer> intList3 = List.of(1, 2, 3);
        List<String> strList3 = intList3.stream()
                .map(String::valueOf) // 정수를 문자열로 변환
                .toList(); // List<String>으로 변환
    }
}
