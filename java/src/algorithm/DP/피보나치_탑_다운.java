package algorithm.DP;

// 탑 다운 방식 - 재귀 함수 이용
public class 피보나치_탑_다운 {

    static long[] dp = new long[100];

    public static void main(String[] args) {
        System.out.println(finbo(50));
    }

    public static long finbo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        if (dp[x] != 0) {
            return dp[x];
        }

        dp[x] = finbo(x - 1) + finbo(x - 2);
        return dp[x];
    }
}
