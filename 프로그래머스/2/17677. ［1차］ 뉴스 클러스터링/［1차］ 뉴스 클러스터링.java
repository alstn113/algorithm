import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        setMap(str1, map1);
        setMap(str2, map2);

        int inter = 0;
        int sum = 0;

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (map2.containsKey(key)) {
                int map2Value = map2.get(key);
                sum += Math.max(value, map2Value);
                inter += Math.min(value, map2Value);
            } else {
                sum += value;
            }
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (!map1.containsKey(key)) {
                sum += value;
            }
        }
        
        if (sum == 0) {
            return 65536;
        }

        return 65536 * inter / sum;
    }

    public void setMap(String str, Map<String, Integer> map) {
        for (int i=0; i<str.length()-1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(!Character.isAlphabetic(c1)) {
                continue;
            }
            if(!Character.isAlphabetic(c2)) {
                i += 1;
                continue;
            }

            String s = "" + c1 + c2;
            s = s.toUpperCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }
}