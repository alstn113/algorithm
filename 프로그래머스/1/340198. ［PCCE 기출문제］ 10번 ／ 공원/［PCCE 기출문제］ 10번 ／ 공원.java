import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int maxSize = 0;
        int n = park.length;
        int m = park[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxSize) {
                answer = mats[i];
                break;
            }
        }

        return answer;
    }
}
