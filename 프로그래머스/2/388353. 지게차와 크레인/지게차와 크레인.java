import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 2차원 배열에서 겉으로 나온 것들을 제거 <--
    // 제일 겉에서 돌면서 BFS 탐색?
    // 예를 들어, # 체크한거는 넘어가고
    // 연속된 문자열인 경우 크레인으로 모든 것들 제거

    int n;
    int m;
    char[][] map;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (int i = 0; i < requests.length; i++) {
            // 크레인 사용
            char target = requests[i].charAt(0);
            if (requests[i].length() == 2) {
                for (int k = 0; k < n; k++) {
                    for (int j = 0; j < m; j++) {
                        if (map[k][j] == target) {
                            map[k][j] = '#';
                        }
                    }
                }
                continue;
            }
            // 지게차 사용
            boolean[][] visited = new boolean[n][m];
            for (int t = 0; t < n; t++) {
                for (int j = 0; j < m; j++) {
                    if (t != 0 && t != n-1 && j != 0 && j != m-1) {
                        continue;
                    }
                    if (visited[t][j]) {
                        continue;
                    }
                    if (map[t][j] == target) {
                        map[t][j] = '#';
                        visited[t][j] = true;
                        continue;
                    }
                    if (map[t][j] == '#') {
                        bfs(target, visited, t, j);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] != '#') {
                    result += 1;
                }
            }
            System.out.println();
        }

        return result;
    }

    public void bfs(char target, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == target) {
                    map[nx][ny] = '#';
                    visited[nx][ny] = true;
                    continue;
                }

                if (map[nx][ny] == '#') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}