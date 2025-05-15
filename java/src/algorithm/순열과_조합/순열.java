package algorithm.순열과_조합;

import java.util.ArrayList;
import java.util.List;

// nPr = n! / (n - r)!
// n개의 원소 중 r개를 뽑는 경우의 수 (순서 상관 있음)
public class 순열 {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int r = 2;

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[input.length];

        backtrack(input, r, new ArrayList<>(), visited, result);

        // 출력
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    private static void backtrack(
            int[] input,
            int r,
            List<Integer> temp,
            boolean[] visited,
            List<List<Integer>> result
    ) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            temp.add(input[i]);
            backtrack(input, r, temp, visited, result);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
