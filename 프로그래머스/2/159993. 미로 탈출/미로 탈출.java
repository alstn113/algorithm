import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, sx, sy, ex, ey, lx, ly;
    static boolean[][] visited;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        // 시작점, 도착점, 레버 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }

        // 시작점에서 레버까지 거리 찾기
        int startToLever = bfs(sx, sy, lx, ly, maps);
        if (startToLever == -1) {
            return -1;
        }

        // 레버에서 도착점까지 거리 찾기
        int leverToExit = bfs(lx, ly, ex, ey, maps);
        if (leverToExit == -1) {
            return -1;
        }

        return startToLever + leverToExit;
    }

    public int bfs(int sx, int sy, int ex, int ey, String[] maps) {
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (x == ex && y == ey) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt + 1});
            }
        }

        return -1;
    }
}