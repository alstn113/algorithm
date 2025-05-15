package algorithm.모노톤_스택;

import java.util.Arrays;
import java.util.Stack;

// 스택의 top 보다 큰 값(또는 작은 값)이 들어올 때까지 pop
// 이후 새로운 값을 push
// 이러면 스택 내부가 항상 정렬된 상태(모노톤 증가/감소)를 유지함.

// 유형
// 1. 오큰수: 오른쪽에 있는 수 중 현재 수보다 큰 값 중 가자 왼쪽 값 찾기
// 2. 히스토그램에서 가장 큰 직사각형
public class 모노톤_스택 {

    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                result[idx] = nums[i];
            }
            stack.push(i);
        }

        // 남은 건 오른쪽에 더 큰 수가 없는 경우 -> -1
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

    // 다음 큰 수를 찾는 문제, 없다면 -1
    public static void main(String[] args) {
        모노톤_스택 sol = new 모노톤_스택();

        int[] nums = {4, 5, 2, 10, 8};
        int[] result = sol.solution(nums);

        System.out.println(Arrays.toString(result)); // [5, 10, 10, -1, -1]
    }
}
