import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        
        for (int i=1; i<arr.length; i++) {
            if(result.get(result.size() - 1) != arr[i]) {
                result.add(arr[i]);
            }
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}