import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> result = new ArrayList<>();
        for (int[] interval : intervals) {
            for (int j = interval[0]; j <= interval[1]; j++) {
                result.add(arr[j]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}