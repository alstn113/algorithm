import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i=0; i<s.length(); i++) {
            Character ctr = s.charAt(i);
            if (dic.containsKey(ctr)) {
                result.add(i - dic.get(ctr));                
            } else {
                result.add(-1);
            }
            dic.put(ctr, i);
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}