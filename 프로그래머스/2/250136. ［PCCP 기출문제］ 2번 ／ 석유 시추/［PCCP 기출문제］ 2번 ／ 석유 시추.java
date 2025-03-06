import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    public int solution(int[][] land) {
        int N = land.length;
        int M = land[0].length;
        visited = new boolean[N][M];

        int[] oils = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 0) {
                    continue;
                }

                if (visited[i][j]) {
                    continue;
                }

                Set<Integer> lines = new HashSet<>();
                int total = bfs(land, i, j, lines);

                for (int l : lines) {
                    oils[l] += total;
                }
            }
        }

        int answer = 0;
        for (int oil : oils) {
            answer = Math.max(answer, oil);
        }
        return answer;
    }

    private int bfs(int[][] land, int x, int y, Set<Integer> lines) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        lines.add(y);

        int total = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (land[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                lines.add(ny);
                total += 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return total;
    }
}
