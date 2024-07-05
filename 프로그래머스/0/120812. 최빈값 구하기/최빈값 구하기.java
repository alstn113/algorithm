import java.util.*;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        int max = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int v : array) {
            int count = map.getOrDefault(v, 0) + 1;
            if (count > max) {
                max = count;
                answer = v;
            } else if (count == max) {
                answer = -1;
            }
            map.put(v, count);
        }
        return answer;
    }
}