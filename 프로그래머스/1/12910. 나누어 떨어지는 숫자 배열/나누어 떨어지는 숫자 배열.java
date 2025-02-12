import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) {
                result.add(a);
            } 
        }
        
        if (result.isEmpty()) {
            return new int[] { -1 };
        }
        
        return result.stream().sorted().mapToInt(v -> v).toArray();
    }
}