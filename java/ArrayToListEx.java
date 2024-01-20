import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ArrayToListEx {
    public static void main(String[] args) {
        // 주의! Arrays.asList()는 고정된 크기의 리스트를 반환한다. (add, remove 불가능)

        // 문자열 타입 배열 -> 리스트
        String[] arr = { "apple", "banana", "orange" };
        List<String> list = new ArrayList<>(Arrays.asList(arr));

        // 리스트 -> 문자열 타입 배열
        String[] arr2 = list.toArray(new String[list.size()]);

        // 문자열 타입 배열 -> 문자열
        String str = String.join(", ", arr);

        // 문자열 -> 문자열 타입 배열
        String[] arr3 = str.split(", ");

        // 정수 타입 배열 -> 리스트
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // 정수 타입 배열 -> 리스트 (Java 9 이상)
        int[] arr4 = { 1, 2, 3 };
        List<Integer> list3 = Arrays.stream(arr4).boxed().collect(Collectors.toList());

        // 리스트 -> 정수 타입 배열
        int[] arr5 = list2.stream().mapToInt(i -> i).toArray();
    }
}
