import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[1] - o2[1];
        });
        for (int[] target : targets) {
            q.offer(target);
        }

        int answer = 1;
        int[] cur = q.poll();
        while (!q.isEmpty()) {
            int[] next = q.poll();
            if (next[0] >= cur[1]) {
                cur = next;
                answer += 1;
            }
        }

        return answer;
    }
}