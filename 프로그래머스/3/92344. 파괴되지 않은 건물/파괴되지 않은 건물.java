class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] nb = new int[n+1][m+1];
        
        for (int[] sk : skill) {
            int type = sk[0]; // type=1 : 감소, type=2 : 증가
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];
            
            int v = type == 1 ? -1 : 1;
            nb[r1][c1] += v * degree;
            nb[r1][c2+1] += -1 * v * degree;
            nb[r2+1][c1] += -1 * v * degree;
            nb[r2+1][c2+1] += v * degree;
        }
        
        for (int i=0; i<n; i++) {
            for (int j=1; j<m; j++) {
                nb[i][j] += nb[i][j-1];
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                nb[j][i] += nb[j-1][i];
            }
        }
        
        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] + nb[i][j] >= 1) {
                    result += 1;
                }
            }
        }
        
        return result;
    }
}