package algorithm.순열과_조합;

import java.util.ArrayList;
import java.util.List;

// nCr = n! / (r!(n - r)!)
// n개의 원소 중 r개를 뽑는 경우의 수 (순서 상관 없음)
public class 조합 {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int r = 2;

        List<List<Integer>> result = new ArrayList<>();
        backtrack(input, r, 0, new ArrayList<>(), result);

        // 출력
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    private static void backtrack(
            int[] input,
            int r,
            int start,
            List<Integer> temp,
            List<List<Integer>> result
    ) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < input.length; i++) {
            temp.add(input[i]);
            backtrack(input, r, i + 1, temp, result); // i + 1로 다음 인덱스로 진행
            temp.remove(temp.size() - 1);             // 백트래킹
        }
    }
}
