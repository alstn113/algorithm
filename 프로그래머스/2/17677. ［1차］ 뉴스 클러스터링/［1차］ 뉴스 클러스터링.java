import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = createMap(str1);
        Map<String, Integer> map2 = createMap(str2);

        int intersection = intersection(map1, map2);
        int union = union(map1, map2);

        if (union == 0) {
            return 65536;
        }

        return (int) ((double) intersection / union * 65536);
    }

    public Map<String, Integer> createMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }
            String sub = String.valueOf(c1).toUpperCase() + String.valueOf(c2).toUpperCase();
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        return map;
    }

    public int intersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        int intersection = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            intersection += Math.min(entry.getValue(), map2.getOrDefault(key, 0));
        }

        return intersection;
    }

    public int union(Map<String, Integer> map1, Map<String, Integer> map2) {
        int union = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            union += Math.max(entry.getValue(), map2.getOrDefault(key, 0));
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                union += entry.getValue();
            }
        }

        return union;
    }
}