import java.util.ArrayList;
import java.util.List;

class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();

        boolean[][] visited = new boolean[N][M];

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X') {
                    continue;
                }

                if (visited[i][j]) {
                    continue;
                }

                answer.add(dfs(maps, i, j, visited));
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        return answer.stream().sorted().mapToInt(v -> v).toArray();
    }

    public int dfs(String[] maps, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int cnt = Integer.parseInt(maps[x].charAt(y) + "");

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) {
                continue;
            }

            if (maps[nx].charAt(ny) == 'X') {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            cnt += dfs(maps, nx, ny, visited);
        }

        return cnt;
    }
}