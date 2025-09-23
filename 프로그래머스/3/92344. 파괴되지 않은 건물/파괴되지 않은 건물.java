class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] temp = new int[n + 1][m + 1];
        for (int[] s : skill) {
            int degree = s[5];
            if (s[0] == 1) {
                degree *= -1;
            }

            temp[s[1]][s[2]] += degree;
            temp[s[1]][s[4] + 1] -= degree;
            temp[s[3] + 1][s[2]] -= degree;
            temp[s[3] + 1][s[4] + 1] += degree;
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                temp[i][j] += temp[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] += temp[i][j - 1];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + temp[i][j] >= 1) {
                    result += 1;
                }
            }
        }

        return result;
    }
}