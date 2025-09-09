class Solution {

    int M;
    int N;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        for (int i = 0; i < 4; i++) {
            key = rotate(key);

            for (int x = -M + 1; x < N; x++) {
                for (int y = -M + 1; y < N; y++) {
                    if (check(key, lock, x, y)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean check(int[][] key, int[][] lock, int xOffset, int yOffset) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int keyVal = 0;
                int keyI = i - xOffset;
                int keyJ = j - yOffset;
                
                if (0 <= keyI && keyI < M && 0 <= keyJ && keyJ < M) {
                    keyVal = key[keyI][keyJ];
                }
                
                if (lock[i][j] + keyVal != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][] cur) {
        int[][] newKey = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                newKey[j][M - 1 - i] = cur[i][j];
            }
        }

        return newKey;
    }
}
