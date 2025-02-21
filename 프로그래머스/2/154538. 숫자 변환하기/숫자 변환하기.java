import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        int count = 0;

        Deque<Integer> q = new LinkedList<>();
        q.push(x);
        visited[x] = true;

        if (x == y) {
            return 0;
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == y) {
                    return count;
                }

                addNext(cur + n, q, visited, y);
                addNext(cur * 2, q, visited, y);
                addNext(cur * 3, q, visited, y);
            }

            count += 1;
        }

        return -1;
    }

    public void addNext(int next, Queue<Integer> q, boolean[] visited, int limit) {
        if (next <= limit && !visited[next]) {
            q.offer(next);
            visited[next] = true;
        }
    }
}