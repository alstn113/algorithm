import java.util.*;

class Solution {
    public int solution(int n, String control) {
        Map<String, Integer> controlMap = Map.of(
                "w", 1,
                "s", -1,
                "d", 10,
                "a", -10
        );
        
        for (int i = 0; i < control.length(); i++) {
            n += controlMap.get(control.substring(i, i + 1));
        }
        return n;
    }
}