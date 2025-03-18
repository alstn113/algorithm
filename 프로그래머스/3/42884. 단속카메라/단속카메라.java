import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int cnt = 1;
        int end = routes[0][1];

        for (int i=1; i<routes.length; i++) {
            int[] cur = routes[i];
            if (cur[0] <= end) continue;

            end = cur[1];
            cnt += 1;
        }

        return cnt;
    }
}