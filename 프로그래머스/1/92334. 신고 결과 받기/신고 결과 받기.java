import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String id : id_list) {
            map.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] split = r.split(" ");
            String from = split[0];
            String to = split[1];
            map.get(to).add(from);
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String s : entry.getValue()) {
                    result.put(s, result.getOrDefault(s, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}