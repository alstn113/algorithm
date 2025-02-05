package algorithm.투_포인터;

import java.util.ArrayList;
import java.util.List;

public class 정렬되어_있는_두_리스트_합치기 {

    // 정렬되어 있는 두 리스트 합치기 - 시간 복잡도 O(N+M) N, M은 각각 리스트의 길이
    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 7};
        int[] list2 = {2, 4, 6, 8};

        List<Integer> result = mergeSortedList(list1, list2);
        System.out.println(result);
    }

    public static List<Integer> mergeSortedList(int[] list1, int[] list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        // 두 리스트 중 하나라도 끝까지 가면 종료
        while (i < list1.length && j < list2.length) {
            if (list1[i] < list2[j]) {
                result.add(list1[i]);
                i += 1;
            } else {
                result.add(list2[j]);
                j += 1;
            }
        }

        // 남은 데이터 처리
        while (i < list1.length) {
            result.add(list1[i]);
            i += 1;
        }

        while (j < list2.length) {
            result.add(list2[j]);
            j += 1;
        }

        return result;
    }
}
