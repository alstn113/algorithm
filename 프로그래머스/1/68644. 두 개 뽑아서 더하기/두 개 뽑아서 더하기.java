import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i]+numbers[j];
                if (result.contains(sum)) {
                    continue;
                }
                result.add(sum);
            }
        }
        
        return result.stream().sorted().mapToInt(v -> v).toArray();
    }
}