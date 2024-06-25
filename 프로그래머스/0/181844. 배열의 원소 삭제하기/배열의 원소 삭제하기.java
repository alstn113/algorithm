import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> result = new ArrayList<>();
        for (int n : arr) {
            boolean isDelete = false;
            
            for (int i : delete_list) {
                if (n == i) {
                    isDelete = true;
                    break;
                }
            }
            
            if (!isDelete) {
                result.add(n);
            }
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}