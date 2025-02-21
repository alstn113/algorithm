import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int INF = (int) 1e9;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visited;
    static int N;
    static int M;
    static int rx, ry, gx, gy;

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new int[N][M];

        // visited 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], INF);
        }

        // 시작점, 도착점 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i].charAt(j) == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry});
        visited[rx][ry] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == gx && y == gy) {
                return visited[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        break;
                    }

                    if (board[nx].charAt(ny) == 'D') {
                        break;
                    }
                }

                nx -= dx[i];
                ny -= dy[i];

                if (visited[x][y] + 1 < visited[nx][ny]) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}