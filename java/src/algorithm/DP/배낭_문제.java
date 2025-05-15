package algorithm.DP;

// 0-1 배낭 문제 (0-1 Knapsack Problem)
// 각 물건의 무게와 가치가 주어졌을 때, 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 구하는 문제
// 각 물건은 하나씩만 존재하며, 넣지 않거나(0), 넣거나(1)의 선택만 가능하다.
public class 배낭_문제 {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // i번째 물건까지 고려했을 때, 배낭의 무게가 j일 때의 최대 가치
        int[][] dp = new int[n + 1][capacity + 1];

        // i는 물건의 인덱스
        for (int i = 1; i <= n; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            // j는 배낭이 담을 수 있는 최대 무게
            for (int j = 0; j <= capacity; j++) {
                if (j < w) {
                    // 현재 물건을 담을 수 없음 - 이전 물건까지의 최대 가치와 동일
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 현재 물건을 담을 수 있음 - 담는 경우와 담지 않는 경우 중 최대 가치 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;

        System.out.println("최대 가치: " + knapsack(weights, values, capacity)); // 출력: 9
    }
}
