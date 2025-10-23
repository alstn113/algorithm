import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int n;
    int m;

    private boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1, 0}); // lux, luy, rdx, rdy, cnt
        Set<String> visited = new HashSet<>();
        visited.add("0 0 0 1");

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if ((cur[0] == n - 1 && cur[1] == m - 1) || (cur[2] == n - 1 && cur[3] == m - 1)) {
                return cur[4];
            }

            // 가로 상태
            if (cur[0] == cur[2]) {
                for (int i = 0; i < 4; i++) {
                    int[] next = new int[]{cur[0] + dx[i], cur[1] + dy[i], cur[2] + dx[i], cur[3] + dy[i], cur[4] + 1};

                    // FIX: 경계 체크 보강
                    if (!inRange(next[0], next[1]) || !inRange(next[2], next[3])) {
                        continue;
                    }
                    if (board[next[0]][next[1]] == 1 || board[next[2]][next[3]] == 1) {
                        continue;
                    }

                    String v = String.format("%d %d %d %d", next[0], next[1], next[2], next[3]);
                    if (visited.contains(v)) {
                        continue;
                    }
                    visited.add(v);
                    q.add(next);
                }

                if (cur[0] > 0 && board[cur[0] - 1][cur[1]] == 0 && board[cur[2] - 1][cur[3]] == 0) {
                    int[] lu = new int[]{cur[0] - 1, cur[1], cur[0], cur[1], cur[4] + 1};
                    String luv = String.format("%d %d %d %d", lu[0], lu[1], lu[2], lu[3]);
                    if (!visited.contains(luv)) {
                        visited.add(luv);
                        q.add(lu);
                    }

                    int[] ru = new int[]{cur[2] - 1, cur[3], cur[2], cur[3], cur[4] + 1};
                    String ruv = String.format("%d %d %d %d", ru[0], ru[1], ru[2], ru[3]);
                    if (!visited.contains(ruv)) {
                        visited.add(ruv);
                        q.add(ru);
                    }
                }

                if (cur[0] < n - 1 && board[cur[0] + 1][cur[1]] == 0 && board[cur[2] + 1][cur[3]] == 0) {
                    int[] ld = new int[]{cur[0], cur[1], cur[0] + 1, cur[1], cur[4] + 1};
                    String ldv = String.format("%d %d %d %d", ld[0], ld[1], ld[2], ld[3]);
                    if (!visited.contains(ldv)) {
                        visited.add(ldv);
                        q.add(ld);
                    }

                    int[] rd = new int[]{cur[2], cur[3], cur[2] + 1, cur[3], cur[4] + 1};
                    String rdv = String.format("%d %d %d %d", rd[0], rd[1], rd[2], rd[3]);
                    if (!visited.contains(rdv)) {
                        visited.add(rdv);
                        q.add(rd);
                    }
                }
            }
            // 세로 상태
            else {
                for (int i = 0; i < 4; i++) {
                    int[] next = new int[]{cur[0] + dx[i], cur[1] + dy[i], cur[2] + dx[i], cur[3] + dy[i], cur[4] + 1};

                    // FIX: 오타 및 누락 보강
                    if (!inRange(next[0], next[1]) || !inRange(next[2], next[3])) {
                        continue;
                    }
                    if (board[next[0]][next[1]] == 1 || board[next[2]][next[3]] == 1) {
                        continue;
                    }

                    String v = String.format("%d %d %d %d", next[0], next[1], next[2], next[3]);
                    if (visited.contains(v)) {
                        continue;
                    }
                    visited.add(v);
                    q.add(next);
                }

                if (cur[1] > 0 && board[cur[0]][cur[1] - 1] == 0 && board[cur[2]][cur[3] - 1] == 0) {
                    int[] lu = new int[]{cur[0], cur[1] - 1, cur[0], cur[1], cur[4] + 1};
                    String luv = String.format("%d %d %d %d", lu[0], lu[1], lu[2], lu[3]);
                    if (!visited.contains(luv)) {
                        visited.add(luv);
                        q.add(lu);
                    }

                    int[] ld = new int[]{cur[2], cur[3] - 1, cur[2], cur[3], cur[4] + 1};
                    String ldv = String.format("%d %d %d %d", ld[0], ld[1], ld[2], ld[3]);
                    if (!visited.contains(ldv)) {
                        visited.add(ldv);
                        q.add(ld);
                    }
                }

                if (cur[1] < m - 1 && board[cur[0]][cur[1] + 1] == 0 && board[cur[2]][cur[3] + 1] == 0) {
                    int[] ru = new int[]{cur[0], cur[1], cur[0], cur[1] + 1, cur[4] + 1};
                    String ruv = String.format("%d %d %d %d", ru[0], ru[1], ru[2], ru[3]);
                    if (!visited.contains(ruv)) {
                        visited.add(ruv);
                        q.add(ru);
                    }

                    int[] rd = new int[]{cur[2], cur[3], cur[2], cur[3] + 1, cur[4] + 1};
                    String rdv = String.format("%d %d %d %d", rd[0], rd[1], rd[2], rd[3]);
                    if (!visited.contains(rdv)) {
                        visited.add(rdv);
                        q.add(rd);
                    }
                }
            }
        }
        return -1;
    }
}