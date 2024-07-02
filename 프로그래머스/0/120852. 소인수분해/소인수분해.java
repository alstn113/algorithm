import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> result = new LinkedHashSet<>();
        int i = 2;
        while (i <= n) {
            if (n % i == 0) {
                n = n / i;
                result.add(i);
            } else {
                i += 1;
            }
        }
        return result.stream().mapToInt(v -> v).toArray();
    }
}