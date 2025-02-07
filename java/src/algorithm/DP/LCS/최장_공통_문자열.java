package algorithm.DP.LCS;

import java.util.Arrays;

// 최장 공통 문자열(Longest Common Substring, LCS) - DP 시간 복잡도 O(N * M)
// 두 개의 문자열에서 공통으로 나타나는 연속된 부분 문자열 중에서 가장 긴 것을 찾는 문제
// ex) "ABCDEF"와 "GBCDF"의 최장 공통 문자열은 "BCD"이다. 길이=3
public class 최장_공통_문자열 {

    public static void main(String[] arg) {
        String str1 = "ABCDEF";
        String str2 = "GBCDF";

        int result = longestCommonSubstring(str1, str2);
        System.out.println("최장 공통 문자열의 길이: " + result);
    }

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 두 문자가 같은 경우
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 좌측 상단 대각선 값 + 1
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
