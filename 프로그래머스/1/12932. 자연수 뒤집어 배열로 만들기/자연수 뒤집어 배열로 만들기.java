import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> result = new ArrayList<>();
        
        while (n > 0) {
            result.add((int) (n % 10));
            n /= 10;
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}