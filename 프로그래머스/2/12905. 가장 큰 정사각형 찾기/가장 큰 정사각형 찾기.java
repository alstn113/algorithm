class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int M = board[0].length;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    answer = Math.max(answer, board[i][j]);
                    continue;
                }
                
                if (board[i][j] == 0) {
                    continue;
                }
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                int v = board[i][j] * board[i][j];
                answer = Math.max(answer, v);
            }
        }

        return answer;
    }
}