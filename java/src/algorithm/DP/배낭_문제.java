package algorithm.DP;

// 0-1 배낭 문제 (0-1 Knapsack Problem)
// 각 물건의 무게와 가치가 주어졌을 때, 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 구하는 문제
// 각 물건은 하나씩만 존재하며, 넣지 않거나(0), 넣거나(1)의 선택만 가능하다.
public class 배낭_문제 {

    // 물건의 무게와 가치
    static final int N = 5;
    static int[] w = {0, 6, 4, 3, 5, 2};
    static int[] v = {0, 13, 8, 6, 12, 4};

    // 배낭의 최대 무게
    static int W = 10;

    // dp[i][j] = i번째 물건까지 고려했을 때, 배낭의 무게가 j일 때의 최대 가치
    static int[][] dp = new int[N + 1][W + 1];

    public static void main(String[] args) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                // i번째 물건의 무게가 최대 무게인 j보다 큰 경우 이전 물건까지의 최대 가치와 동일
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // i번째 물건을 넣을 수 있는 경우
                // (j - w[i]의 무게에 i번째 물건을 넣은 경우)와 (넣지 않은 경우인 i - 1번째 물건까지의 최대 가치) 중 최대 가치 선택
                else {
                    // i번째 물건을 넣지 않은 경우와 넣은 경우 중 최대 가치 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[N][W]);
    }
}
