import java.util.*;

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    int max = 1;
    
    public int[] solution(int n, int[] info) {
        // 같은 횟수로 맞춤 -> 어피치 점수, 아무도 못 맞춤 -> 둘 다 0점
        // 여러 경우 중 가장 큰 점수 차이로 우승 -> 다음 정렬로 가장 낮은 점수를 더 많이 맞힌 경우
        
        dfs(n, info, new ArrayList<>());
        
        if (result.isEmpty()) {
            return new int[] {-1};
        }
        
        result.sort((o1, o2) -> {
           for (int i=10; i>-1; i--) {
               if (!o2.get(i).equals(o1.get(i))) {
                   return o2.get(i) - o1.get(i);
               }
           }    
            return 0;
        });
        
        return result.get(0).stream().mapToInt(i-> i).toArray();
    }
    
    public void dfs(int remain, int[] info, List<Integer> cur) {
        if (cur.size() == 11) {
            if (remain > 0) {
                cur.set(10, cur.get(10) + remain);
            }
            int aSum = 0;
            int bSum = 0;
            
            for (int i=0; i<11; i++) {
                if (info[i] == 0 && cur.get(i) == 0) {
                    continue;
                }
                
                if (info[i] >= cur.get(i)) {
                    aSum += 10-i;
                } else {
                    bSum += 10-i;
                }
            }
            
            int diff = bSum - aSum;
            if (diff == 0) return;
            if (diff == max) {
                result.add(new ArrayList<>(cur));
            } else if (diff > max) {
                max = diff;
                result = new ArrayList<>();
                result.add(new ArrayList<>(cur));
            } 
            
            return;
        }
        
        int idx = cur.size();
        if (info[idx] < remain) {
            cur.add(info[idx] + 1);
            int newRemain = remain - (info[idx]+1);
            dfs(newRemain, info, new ArrayList<>(cur));
            cur.remove(cur.size()-1);
        }
        
        cur.add(0);
        dfs(remain, info, new ArrayList<>(cur));
        cur.remove(cur.size()-1);
    }
}