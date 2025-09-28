import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        String newStr = s.substring(2, s.length() - 2);
        String[] split = newStr.split("}.\\{");

        Map<Integer, Integer> map = new HashMap<>();
        for (String v : split) {
            String[] ssplit = v.split(",");
            for (String k : ssplit) {
                int vv = Integer.parseInt(k);
                map.put(vv, map.getOrDefault(vv, 0) + 1);
            }
        }

        int[] result = new int[split.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[split.length - entry.getValue()] = entry.getKey();
        }

        return result;
    }
}