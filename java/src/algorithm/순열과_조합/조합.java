package algorithm.순열과_조합;


import java.util.ArrayList;
import java.util.List;

// nCr = n! / r! * (n - r)!
// n개의 원소 중 r개를 뽑는 경우의 수 (순서 상관 없음)
public class 조합 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;

        List<List<Integer>> result = combination(arr, r);

        System.out.println("조합 결과: " + result);
        System.out.println("총 경우의 수: " + result.size());
    }

    public static List<List<Integer>> combination(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(arr, r, result, new ArrayList<>(), 0);

        return result;
    }

    public static void dfs(int[] arr, int r, List<List<Integer>> result, List<Integer> current, int startIndex) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            current.add(arr[i]);

            dfs(arr, r, result, current, i + 1);

            current.removeLast();
        }
    }
}
