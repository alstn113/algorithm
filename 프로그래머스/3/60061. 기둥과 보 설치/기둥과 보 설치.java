import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][][] board = new boolean[n+1][n+1][2];
        
        // 로직 실행 시 세로에 -n을 하고 출력 시 +n 을 해야함.
        for (int[] bf : build_frame) {
            int x = bf[0]; // 가로
            int y = n - bf[1]; // 세로
            int a = bf[2]; // 0은 기둥, 1은 보 
            int b = bf[3]; // 0은 삭제, 1은 설치
            
            if (b == 1) {
                if (check(board, y, x, a, n)) {
                    board[y][x][a] = true;
                }
            } else {
                // 삭제 가능한가?
                board[y][x][a] = false;
                if (!allcheck(board, n)) {
                    board[y][x][a] = true;
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        for (int j=0; j<n+1; j++) {
            for (int i=n; i>-1; i--) {
                for (int k=0; k<2; k++) {
                    if (board[i][j][k]) {
                        result.add(new int[] {j, n - i, k});
                    }
                }
            }
        }

        return result.stream().toArray(int[][]::new);
    }
    
    public boolean check(boolean[][][] board, int y, int x, int a, int n) {
        if (a == 0) { // 기둥 - 바닥에 있거나 보 위에 있거나 기둥 위에 있거나 
            if (y == n || 
                (x < n && board[y][x][1]) || 
                (x > 0 && board[y][x-1][1]) || 
                (y != n && board[y+1][x][0])
               ) 
            {
                return true;
            }
        } else { // 보
            // 왼쪽 또는 오른쪽에 기둥이 있는가? 
            // 보 중간인 경우
            if (
                board[y+1][x][0] || 
                board[y+1][x+1][0] || 
                (0<x && x<n && board[y][x-1][1] && board[y][x+1][1])
            ) {
                return true;
            }
        }
        return false;
    }
    
    public boolean allcheck(boolean[][][] board, int n) {
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                for (int k=0; k<2; k++) {
                    if (board[i][j][k] && !check(board, i, j, k, n)) { 
                        return false;
                    }
                }
            }
        }
        return true;
    }
}