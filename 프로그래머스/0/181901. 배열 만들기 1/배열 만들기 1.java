import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = k; i <= n; i += k) {
            result.add(i);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}