import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        String result = "";
        Map<Integer, String> control = new HashMap<>();
        control.put(1, "w");
        control.put(-1, "s");
        control.put(10, "d");
        control.put(-10, "a");

        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            result += control.get(diff);
        }
        
        return result;
    }
}