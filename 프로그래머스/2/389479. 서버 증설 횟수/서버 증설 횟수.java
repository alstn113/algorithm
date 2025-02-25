import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int current = 0;
        int answer = 0;

        for (int player : players) {
            int v = player < current * m ? 0 : (player - current * m) / m;
            answer += v;

            q.offer(v);
            current += v;

            if (q.size() == k) {
                current -= q.poll();
            }
        }

        return answer;
    }
}