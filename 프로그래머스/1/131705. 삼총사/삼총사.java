import java.util.*;

class Solution {
    
    static int count = 0;
    
    public int solution(int[] number) {
        dfs(number, new ArrayList<>(), 0);
        
        return count;
    }
    
    public void dfs(int[] arr, List<Integer> current, int startIndex) {
        if(current.size() == 3) {
            int sum = current.stream().mapToInt(v -> v).sum();
            if (sum == 0) {
                count += 1;
            }
        }
        
        for (int i=startIndex; i<arr.length; i++) {
            current.add(arr[i]);
            dfs(arr, current, i+1);
            current.remove(current.size() - 1);
        }
    }
}