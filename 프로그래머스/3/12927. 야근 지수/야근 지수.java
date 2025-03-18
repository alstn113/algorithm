import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.offer(work);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int v = pq.poll();
            n -= 1;
            int next = v-1;
            if (next == 0) continue;
            pq.offer(next);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int v = pq.poll();
            answer += v * v;
        }
        
        return answer;
    }
}