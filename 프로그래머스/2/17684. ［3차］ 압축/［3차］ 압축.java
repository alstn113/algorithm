import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 가장 긴 일치 찾기
        // 출력 및 입력 제거
        // 처리되지 않은 글자 저장
        
        Map<String, Integer> map = new HashMap<>();
        String alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int idx = 1;
        while (idx < alpha.length()) {
            map.put("" + alpha.charAt(idx), idx);
            idx += 1;            
        }
        
        // ---
        
        List<Integer> result = new ArrayList<>();
        
        int k=0;
        String tmp = "";
        while(k<msg.length()) {
            String cur = "" + msg.charAt(k);
            String target = tmp + msg.charAt(k);
            if (map.containsKey(target)) {
                tmp = target;
                k += 1;
            } else {
                // KA는 target; 저장
                map.put(target, idx);
                idx += 1;
                
                // K는 tmp; 출력
                result.add(map.get(tmp));
            
                // 
                tmp = "";
            }            
        }
        
        if (!tmp.isBlank()) {
            result.add(map.get(tmp));
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }
}