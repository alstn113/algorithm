import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 200000000;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < stones.length; i++) {
            if (i >= k) {
                if (!deque.isEmpty() && deque.peek() <= i - k) {
                    deque.poll();
                }
            }

            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peek()]);
            }
        }

        return answer;
    }
}