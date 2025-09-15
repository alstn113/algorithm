import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        createMap(str1, map1);
        createMap(str2, map2);

        int intersection = 0;
        int sum = 0;

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            sum += entry.getValue();
            intersection += Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0));
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            sum += entry.getValue();
        }
        sum -= intersection;

        if (intersection == 0 && sum == 0) {
            return 65536;
        }

        return (int) ((double) intersection / sum * 65536);
    }

    public void createMap(String str, Map<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                continue;
            }
            if (!Character.isAlphabetic(str.charAt(i + 1))) {
                i += 1;
                continue;
            }
            String target = str.substring(i, i + 2).toLowerCase();
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
    }
}