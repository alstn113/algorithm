import java.util.Arrays;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean isBombed = false;
            char[][] newBoard = new char[m][n];
            for (int i = 0; i < m; i++) {
                newBoard[i] = Arrays.copyOf(map[i], n);
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    char target = map[i][j];
                    if (target == '#') {
                        continue;
                    }
                    if (target == map[i - 1][j] && target == map[i][j - 1] && target == map[i - 1][j - 1]) {
                        isBombed = true;
                        newBoard[i][j] = '#';
                        newBoard[i - 1][j] = '#';
                        newBoard[i][j - 1] = '#';
                        newBoard[i - 1][j - 1] = '#';
                    }
                }
            }

            if (!isBombed) {
                break;
            }

            // 아래로 내리기
            for (int i = 0; i < n; i++) { // 열
                for (int j = m - 2; j > -1; j--) { // 행
                    int curIdx = j;
                    char current = newBoard[j][i];

                    if (current == '#') {
                        continue;
                    }

                    while (curIdx < m - 1) {
                        if (newBoard[curIdx + 1][i] == '#') {
                            newBoard[curIdx][i] = '#';
                            newBoard[curIdx + 1][i] = current;
                            curIdx += 1;
                        } else {
                            break;
                        }
                    }
                }
            }

            map = newBoard;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '#') {
                    result += 1;
                }
            }
        }

        return result;
    }
}