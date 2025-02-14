class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(String[][] board, int h, int w) {
        String target = board[h][w];

        int N = board.length;
        int M = board[0].length;

        int result = 0;

        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (board[nx][ny].equals(target)) {
                result += 1;
            }
        }

        return result;
    }
}