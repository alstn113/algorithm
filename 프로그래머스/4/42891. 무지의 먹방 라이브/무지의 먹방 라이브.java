import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int f : food_times) sum += f;
        if (sum <= k) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] > 0) pq.offer(new int[]{i, food_times[i]});
        }

        long remain = pq.size();
        long offset = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.peek();
            long v = cur[1] - offset;
            if (v == 0) { 
                pq.poll();
                remain--;
                continue;
            }

            if (k >= remain * v) {
                k -= remain * v;
                offset += v;
                pq.poll();
                remain--;
            } else break;
        }

        if (pq.isEmpty()) return -1;

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll()[0]);
        Collections.sort(result);

        int answer = (int) (k % result.size());
        return result.get(answer) + 1;
    }
}
