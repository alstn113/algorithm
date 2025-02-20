class Solution {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    private void dfs(int[] numbers, int sum, int index, int target) {
        if (index == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }

        dfs(numbers, sum + numbers[index], index + 1, target);
        dfs(numbers, sum - numbers[index], index + 1, target);
    }
}
