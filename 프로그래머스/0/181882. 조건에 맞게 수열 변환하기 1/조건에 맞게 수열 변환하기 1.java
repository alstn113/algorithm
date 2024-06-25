import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr).map(v -> {
            if(v >= 50 && v % 2 == 0) {
                return v / 2;
            }
            else if(v < 50 && v % 2 == 1) {
                return v * 2;
            }
            return v;
        }).toArray();
    }
}