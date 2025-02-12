import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] { -1 };
        }
            
        int m = arr[0];
        for (int a : arr) {
            m = Math.min(m, a);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int a : arr) {
            if(m != a) result.add(a);
        }
        
        return result.stream().mapToInt(v->v).toArray();
    }
}