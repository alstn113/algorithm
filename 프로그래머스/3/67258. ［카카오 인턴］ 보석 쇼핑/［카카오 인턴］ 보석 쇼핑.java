import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
      Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = kinds.size();
        
        Map<String, Integer> count = new HashMap<>();
        int left = 0;
        int bestLeft = 0;
        int bestRight = gems.length - 1;
        int bestLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < gems.length; right++) {
            String gr = gems[right];
            count.merge(gr, 1, Integer::sum);
            
            while (count.size() == totalKinds) {
                int currLen = right - left + 1;
                if (currLen < bestLen) {
                    bestLen = currLen;
                    bestLeft = left;
                    bestRight = right;
                }
                
                String gl = gems[left];
                int c = count.get(gl) - 1;
                if (c == 0) {
                    count.remove(gl);
                } else {
                    count.put(gl, c);
                }
                left++;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = bestLeft + 1;
        answer[1] = bestRight + 1;
        return answer;
    }
}