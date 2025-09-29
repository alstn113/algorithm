import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 서로에게 준 개수가 많으면 준다. 
        // 같거나 주고 받은 기록이 없으면 선물 지수를 통해 결정한다. 작은 사람이 더 큰 사람에게 준다.
        // 선물 지수도 같으면 주고 받지 않는다.
        int n = friends.length;
        
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            map.put(friends[i], i);
        }        
        
        Map<String, Integer> fromMap = new HashMap<>();
        Map<String, Integer> toMap = new HashMap<>();
    
        
        int[][] ft = new int[n][n];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];
            fromMap.put(from, fromMap.getOrDefault(from, 0) + 1);
            toMap.put(to, toMap.getOrDefault(to, 0) + 1);
            
            int fromIdx = map.get(from);
            int toIdx = map.get(to);
            
            ft[fromIdx][toIdx] += 1;
        }
        
        for (int i=0; i<n; i++) {
            String f = friends[i];
            fromMap.put(f, fromMap.getOrDefault(f, 0) - toMap.getOrDefault(f, 0));
        } 
        
        
        
        int[] result = new int[n];
        for (int i=0; i<n-1; i++) {
            String a = friends[i];
            
            for (int j=i+1; j<n; j++) {
                String b = friends[j];
                if (ft[i][j] > ft[j][i]) {
                    result[i] += 1;
                } else if (ft[i][j] < ft[j][i]) {
                    result[j] += 1;
                } else {
                    if (fromMap.get(a) > fromMap.get(b)) {
                        result[i] += 1;
                    } else if (fromMap.get(a) < fromMap.get(b)) {
                        result[j] += 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
}
