import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = n; i < num_list.length; i++) {
            result.add(num_list[i]);
        }
        for (int i = 0; i < n; i++) {
            result.add(num_list[i]);
        }   
        return result.stream().mapToInt(i -> i).toArray();
    }
}