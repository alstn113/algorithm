class Solution {
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            int v = dp[i-1] + dp[i-2];
            dp[i] = v % 1234567;
        }
        
        return dp[n];
    }
}