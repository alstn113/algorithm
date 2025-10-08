import java.util.*;

class Solution {
    
    int M;
    int N;
    
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        
        boolean answer = false;
        
        for (int q=0; q<4; q++) {
            // xofs는 열, yofs는 행
            // 2 ~ -2
            for (int xofs=-N; xofs<=M; xofs++) {
                for (int yofs=-N; yofs<=M; yofs++) {
                    if(check(xofs, yofs, key, lock)) {
                        return true;
                    }
                }
            }
            
            // 회전
            key = rotate(key);
        }
        
        return false;
    }
    
    public boolean check(int xofs, int yofs, int[][] key, int[][] lock) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int v = 0;
                if (i + yofs >= 0 && i + yofs < M && j + xofs >= 0 && j + xofs < M) {
                    v = key[i + yofs][j + xofs];
                }
                
                if (lock[i][j] + v != 1) {
                    return false;
                }                
            }
        }
        
        return true;
    }
    
    public int[][] rotate(int[][] key) {
        int[][] newKey = new int[M][M];
        
        // 대각선 대칭
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                newKey[j][i] = key[i][j];
            }
        }
        
        // 대칭
        for (int i=0; i<M; i++) {
            for (int j=0; j<M/2; j++) {
                int tmp = newKey[i][j];
                newKey[i][j] = newKey[i][M-1-j];
                newKey[i][M-1-j] = tmp;
            }
        }
        
        return newKey;
    }
}