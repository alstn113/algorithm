class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        for (int i = 0; i < 4; i++) {
            key = rotate(key, m);

            for (int x = -m + 1; x < n; x++) {
                for (int y = -m + 1; y < n; y++) {
                    if (check(key, lock, x, y, m, n)) {
                        return true;
                    }
                }
            }
        }

        return false; 
    }

    public boolean check(int[][] key, int[][] lock, int xOffset, int yOffset, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int keyVal = 0;
                int keyI = i - xOffset;
                int keyJ = j - yOffset;
                if (0 <= keyI && keyI < m && 0 <= keyJ && keyJ < m) {
                    keyVal = key[keyI][keyJ];
                }
                if (lock[i][j] + keyVal != 1) { 
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][] cur, int m) {
        int[][] newKey = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newKey[j][m - 1 - i] = cur[i][j]; 
            }
        }

        return newKey;
    }
}
