import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 가장 짧은 구간을 찾기. 
        // but 짧은게 여러 개라면 앞 번호를 찾기.
        // 같지 않고 보다 큰 값이 나오면 갱신하면 됨.
        
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            map.put(gem, 0);
        }
        int typeCnt = map.size();
        int n = gems.length;
        
        int curCnt = 0;
        
        int left1 = 0;
        int right1 = n-1;

        int right = -1;
        for (int left=0; left<n; left++) {
            while(right < n-1 && curCnt != typeCnt) {
                right += 1;
                String curGem = gems[right];
                if (map.get(curGem) == 0) {
                    curCnt += 1;
                }
                map.put(curGem, map.get(curGem) + 1);
            }
            
            if (curCnt == typeCnt) {
                if (right1 - left1 > right - left) {
                    left1 = left;
                    right1 = right;
                }
            }
            
            String v = gems[left];
            if(map.get(v) == 1) {
                curCnt -= 1;
            }
            map.put(v, map.get(v) - 1);
        }
        
        return new int[] {left1 + 1, right1 + 1};
    }
}