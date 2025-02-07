package algorithm.DP.LCS;

// 최장 공통 부분 수열(Longest Common Subsequence, LCS) - DP 시간 복잡도 O(N * M)
// 두 수열이 주어졌을 때, 두 수열의 공통 부분 수열 중 가장 긴 것을 찾는 문제 (연속적 x)
// ex) "ABCDEF"와 "GBCDF"의 LCS는 "BCDF"이다. 길이=4
public class 최장_공통_부분_수열 {

    public static void main(String[] arg) {
        String str1 = "ABCDEF";
        String str2 = "GBCDF";

        int result = longestCommonSubsequence(str1, str2);
        System.out.println("최장 공통 부분 수열의 길이: " + result);
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 두 문자가 같은 경우
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 좌측 상단 대각선 값 + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 좌측 값과 상단 값 중 큰 값 (연속적이지 않으므로)
                }
            }
        }

        return dp[n][m];
    }
}
