import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int c : course) {
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {
                if (order.length() < c) {
                    continue;
                }

                String[] split = order.split("");
                Arrays.sort(split);

                dfs(map, 0, "", split, c);
            }

            int max = 2;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    result.add(entry.getKey());
                }
            }
        }

        return result.stream().sorted().toArray(String[]::new);
    }

    public void dfs(Map<String, Integer> map, int startIdx, String cur, String[] str, int limit) {
        if (cur.length() == limit) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }

        for (int i = startIdx; i < str.length; i++) {
            dfs(map, i + 1, cur + str[i], str, limit);
        }
    }
}