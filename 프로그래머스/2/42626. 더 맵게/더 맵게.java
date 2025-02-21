import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        int answer = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            int newScoville = first + second * 2;
            pq.add(newScoville);
            answer += 1;
        }

        return answer;
    }
}