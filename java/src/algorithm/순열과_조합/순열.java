package algorithm.순열과_조합;

import java.util.ArrayList;
import java.util.List;

// nPr = n! / (n - r)!
// n개의 원소 중 r개를 뽑는 경우의 수 (순서 상관 있음)
public class 순열 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;

        List<List<Integer>> result = permutation(arr, r);

        System.out.println("순열 결과: " + result);
        System.out.println("총 경우의 수: " + result.size());
    }

    public static List<List<Integer>> permutation(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];

        // dfs 로 순열 구하기
        dfs(arr, r, result, new ArrayList<>(), visited);

        return result;
    }

    public static void dfs(int[] arr, int r, List<List<Integer>> result, List<Integer> current, boolean[] visited) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            // 방문 처리
            visited[i] = true;
            current.add(arr[i]);

            dfs(arr, r, result, current, visited);

            // 방문 처리 해제
            visited[i] = false;
            current.removeLast();
        }
    }
}
