import java.util.Arrays;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            // 임시 맵 복사
            char[][] tmp = new char[m][n];
            for (int i = 0; i < m; i++) {
                tmp[i] = map[i].clone();
            }

            // 2x2 모노톤 찾기
            boolean found = false; // 블록이 발견되었는지 여부
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char target = map[i][j];

                    if (target == ' ') {
                        continue;
                    }

                    char right = map[i][j + 1];
                    char down = map[i + 1][j];
                    char rightDown = map[i + 1][j + 1];

                    if (target == right && target == down && target == rightDown) {
                        tmp[i][j] = ' ';
                        tmp[i][j + 1] = ' ';
                        tmp[i + 1][j] = ' ';
                        tmp[i + 1][j + 1] = ' ';
                        found = true; // 블록이 발견됨
                    }
                }
            }

            // 아무 블록도 발견되지 않으면 종료
            if (!found) {
                break;
            }

            // 밑으로 내리기
            for (int col = 0; col < n; col++) {
                for (int row = m - 1; row >= 0; row--) {
                    if (tmp[row][col] == ' ') {
                        for (int k = row - 1; k >= 0; k--) {
                            if (tmp[k][col] != ' ') {
                                tmp[row][col] = tmp[k][col];
                                tmp[k][col] = ' ';
                                break;
                            }
                        }
                    }
                }
            }

            // 맵 업데이트
            map = tmp;
        }

        return count(map);
    }

    private int count(char[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == ' ') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
