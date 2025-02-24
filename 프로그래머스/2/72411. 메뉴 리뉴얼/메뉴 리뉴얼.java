import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int limit : course) {
            answer.addAll(comb(orders, limit));
        }

        Collections.sort(answer);
        
        return answer.toArray(String[]::new);
    }

    public List<String> comb(String[] orders, int n) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            order = new String(orderArr);
            
            combHelper(order, n, "", 0, map);
        }
        
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max && entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public void combHelper(String order, int n, String cur, int start, Map<String, Integer> map) {
        if (cur.length() == n) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int i = start; i < order.length(); i++) {
            combHelper(order, n, cur + order.charAt(i), i + 1, map);
        }
    }
}