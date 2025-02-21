class Solution {
    // 양방향이므로 하, 좌, 우 방향만 검사
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[] answer;

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }

    public void dfs(int num, int x, int y, int count, String[] places) {
        if (count > 2) {
            return;
        }

        if (count > 0 && places[x].charAt(y) == 'P') {
            answer[num] = 0;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }

            if (visit[nx][ny]) {
                continue;
            }

            if (places[nx].charAt(ny) == 'X') {
                continue;
            }

            visit[nx][ny] = true;
            dfs(num, nx, ny, count + 1, places);
            visit[nx][ny] = false;
        }
    }
}
