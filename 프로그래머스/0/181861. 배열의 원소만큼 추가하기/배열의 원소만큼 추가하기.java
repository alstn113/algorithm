import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (Integer n : arr) {
            result.addAll(Collections.nCopies(n, n));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}