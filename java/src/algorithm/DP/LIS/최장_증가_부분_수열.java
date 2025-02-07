package algorithm.DP.LIS;

// 최장 증가 부분 수열(Longest Increasing Subsequence, LIS) - DP 시간 복잡도 O(N^2)
// 주어진 수열에서 가장 긴 증가하는 부분 수열의 길이를 구하는 문제
public class 최장_증가_부분_수열 {

    public static void main(String[] args) {
        int[] nums = {10, 20, 10, 30, 20, 50}; // {10, 20, 30, 50} = 4
        int length = LongestIncreasingSubsequence(nums);

        System.out.println("최장 증가 부분 수열의 길이: " + length);
    }

    public static int LongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 자기 자신만 포함하는 수열의 길이로 초기화

            for (int j = 0; j < i; j++) {
                // 현재 값이 이전 값보다 크고, 이전 값의 길이 + 1이 현재 값의 길이보다 크다면 갱신
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
