package algorithm.모노톤;

import java.util.Arrays;
import java.util.Stack;

// 각 원소의 오른쪽에서 자신보다 큰 첫 번째 수를 찾는 문제
public class 모노톤 {

    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer, -1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                answer[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return answer;
    }

    // 다음 큰 수를 찾는 문제, 없다면 -1
    public static void main(String[] args) {
        모노톤 sol = new 모노톤();

        int[] nums = {4, 5, 2, 10, 8};
        int[] result = sol.solution(nums);

        System.out.println(Arrays.toString(result)); // [5, 10, 10, -1, -1]
    }
}
