class Solution {

    // key 관련
    int n;
    int m;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = key[0].length;

        for (int c = 0; c < 4; c++) {
            // xy offset 구하기
            for (int i = -n + 1; i <= lock.length - 1; i++) {
                for (int j = -m + 1; j <= lock[0].length - 1; j++) {

                    boolean flag = false;
                    for (int x = 0; x < lock.length; x++) {
                        for (int y = 0; y < lock[0].length; y++) {
                            int keyValue = 0;
                            if (x - i >= 0 && x - i < n && y - j >= 0 && y - j < m) {
                                keyValue = key[x - i][y - j];
                            }

                            if (lock[x][y] + keyValue != 1) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    }

                    if (!flag) {
                        return true;
                    }
                }
            }

            // 회전
            key = rotate(key);
        }

        return false;
    }

    public int[][] rotate(int[][] key) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = key[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = map[i][j];
                map[i][j] = map[i][m - 1 - j];
                map[i][m - 1 - j] = temp;
            }
        }

        return map;
    }
}