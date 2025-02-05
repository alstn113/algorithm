package algorithm.DFS;

public class DFS_2차원_배열 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited = new boolean[4][6];

    // N x M 크기의 직사각형 형태의 미로
    // 0은 이동할 수 없는 칸, 1은 이동할 수 있는 칸
    // (0, 0)에서 (N-1, M-1)까지 이동하는 최소 칸의 개수
    static int[][] arr = {
            {1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1}
    };
    static int N = arr.length;
    static int M = arr[0].length;
    static int minSteps = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = arr.length;
        int m = arr[0].length;

        dfs(0, 0, 1);

        System.out.println(minSteps == Integer.MAX_VALUE ? -1 : minSteps); // 도달하지 못하는 경우 -1 출력
    }

    public static void dfs(int x, int y, int count) {
        visited[x][y] = true;

        if (x == N - 1 && y == M - 1) {
            minSteps = Math.min(minSteps, count);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (arr[nx][ny] == 0) {
                continue;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny, count + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
