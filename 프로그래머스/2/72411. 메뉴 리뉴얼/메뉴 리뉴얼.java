import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for (int co : course) { // 2, 3, 4 ...
            Map<String, Integer> map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() < co) {
                    continue;
                }
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                dfs(charArray, map, co, "", 0);
            }
            
            List<String> tmp = new ArrayList<>();
            int max=0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() < 2) {
                    continue;
                }
                
                if (entry.getValue() == max) {
                    tmp.add(entry.getKey());
                } else if (entry.getValue() > max) {
                    max = entry.getValue();
                    tmp = new ArrayList<>();
                    tmp.add(entry.getKey());
                }
            }
            result.addAll(tmp);
        }
        
        Collections.sort(result);
        return result.toArray(String[]::new);
    }
    
    public void dfs(char[] charArray, Map<String, Integer> map, int co, String cur, int startIdx) {
        if (cur.length() == co) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for (int i=startIdx; i<charArray.length; i++) {
            String next = cur + charArray[i];
            dfs(charArray, map, co, next, i+1);
        }
    }
}