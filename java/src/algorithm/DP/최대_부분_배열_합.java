package algorithm.DP;

// 주어진 배열에서 연속된 부분 배열의 합 중 최대값을 구하는 문제
public class 최대_부분_배열_합 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(nums); // {4, -1, 2, 1} = 6

        System.out.println("최대 부분 배열의 합: " + maxSum);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 현재 요소를 포함한 새로운 배열을 만들지, 기존 배열에 추가할지 결정
            sum = Math.max(nums[i], sum + nums[i]);
            // 전체 최대 부분 배열 합 갱신
            max = Math.max(max, sum);
        }

        return max;
    }
}
