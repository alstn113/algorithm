class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }

        int max = 0;
        for (int i = 0; i < land[0].length; i++) {
            max = Math.max(max, land[land.length - 1][i]);
        }
        return max;
    }
}