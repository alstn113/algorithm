import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                    continue;
                }

                if (maps[nx][ny] == 0) {
                    continue;
                }

                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        if (maps[N - 1][M - 1] == 1) {
            return -1;
        }
        return maps[N - 1][M - 1];
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}