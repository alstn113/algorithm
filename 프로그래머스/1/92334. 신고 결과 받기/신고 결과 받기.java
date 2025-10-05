import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> fromMap = new HashMap<>();
        Map<String, Set<String>> toMap = new HashMap<>();
        
        for (String id : id_list) {
            fromMap.put(id, new HashSet<>());
            toMap.put(id, new HashSet<>());
        }
        
        for (String rp : report) {
            String[] split = rp.split(" ");
            String from = split[0];
            String to = split[1];
            
            fromMap.get(from).add(to); // 누가 누구를 신고했나?
            toMap.get(to).add(from); // 누가 누구에게 신고당했나?
        }
        
        int[] result = new int[id_list.length];
        for (int i=0; i<result.length; i++) {
            Set<String> reported = fromMap.get(id_list[i]);
            int cnt = 0;
            for (String r : reported) {
                if(toMap.get(r).size() >= k) {
                    cnt += 1;
                }
            }
            result[i] = cnt;
        }
        
        return result;
    }
}