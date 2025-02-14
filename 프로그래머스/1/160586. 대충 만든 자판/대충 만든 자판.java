import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (dic.containsKey(c)) {
                    if (dic.get(c) > j + 1) {
                        dic.put(c, j + 1);
                    }
                } else {
                    dic.put(c, j + 1);
                }
            }
        }
        
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int answer = 0;
            char[] targetArr = targets[i].toCharArray();
            for (char c : targetArr) {
                if (dic.containsKey(c)) {
                    answer += dic.get(c);
                } else {
                    answer = -1;
                    break;
                }
            }
            
            result[i] = answer;
        }
        
        return result;
    }
}