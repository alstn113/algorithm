import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        long targetSum = (sum1 + sum2) / 2;

        int moveCount = 0;
        int maxMoves = (queue1.length + queue2.length) * 2; 

        while (moveCount < maxMoves) {
            if (sum1 == targetSum) {
                return moveCount;
            }

            if (sum1 > targetSum) {
                int value = q1.poll();
                sum1 -= value;
                q2.offer(value);
                sum2 += value;
            } else {
                int value = q2.poll();
                sum2 -= value;
                q1.offer(value);
                sum1 += value;
            }

            moveCount++;
        }

        return -1; 
    }
}
