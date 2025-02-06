package algorithm.DP;

// 바텀 업 방식 - 반복문 이용
public class 피보나치_바텀_업 {

    static long[] dp = new long[100];

    public static void main(String[] args) {
        System.out.println(finbo(50));
    }

    public static long finbo(int x) {
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[x];
    }
}
