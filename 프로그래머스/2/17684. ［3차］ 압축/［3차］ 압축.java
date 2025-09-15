import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> store = new HashMap<>();
        String alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 1; i < alpha.length(); i++) {
            String target = String.valueOf(alpha.charAt(i));
            store.put(target, i);
        }
        int nextKey = alpha.length();

        // ----
        List<Integer> result = new ArrayList<>();

        int i = 1;
        String temp = String.valueOf(msg.charAt(0));
        while (i < msg.length()) {
            String next = String.valueOf(msg.charAt(i));
            String newTemp = temp + next;
            if (!store.containsKey(newTemp)) {
                result.add(store.get(temp));
                store.put(newTemp, nextKey);
                nextKey += 1;
                temp = next;
                i += 1;
                continue;
            }
            temp = newTemp;
            i += 1;
        }
        result.add(store.get(temp));

        return result.stream().mapToInt(v -> v).toArray();
    }
}