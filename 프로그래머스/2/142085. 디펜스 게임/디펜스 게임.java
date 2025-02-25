import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int round = 0;
        for (int e : enemy) {
            pq.offer(e);
            n -= e;

            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k -= 1;
                } else {
                    break;
                }
            }

            round++;
        }

        return round;
    }
}