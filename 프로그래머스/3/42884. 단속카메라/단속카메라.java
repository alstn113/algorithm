import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        List<int[]> routeList = new ArrayList<>(Arrays.asList(routes));
        routeList.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int cnt = 1;
        int end = routeList.get(0)[1];
        
        for (int i=1; i<routes.length; i++) {
            int[] cur = routeList.get(i);
            if (cur[0] <= end) continue;
            
            end = cur[1];
            cnt += 1;
        }
        
        return cnt;
    }
}