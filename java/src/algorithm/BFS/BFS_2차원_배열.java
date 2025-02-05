package algorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_2차원_배열 {

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

    public static void main(String[] args) {
        int n = arr.length;
        int m = arr[0].length;

        int result = bfs(n, m);

        System.out.println(result);
    }

    public static int bfs(int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();

           for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    queue.offer(new Node(nx, ny));
                    arr[nx][ny] = arr[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }

        return arr[n - 1][m - 1];
    }
}

class Node {

    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}