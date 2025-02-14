import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> dic = new HashMap<>();
        for (String player : participant) {
            dic.put(player, dic.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            dic.put(player, dic.get(player) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : dic.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}