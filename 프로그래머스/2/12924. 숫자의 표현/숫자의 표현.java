class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int start = 1; start <= n / 2; start++) {
            int sum = start;

            for (int current = start + 1; sum < n; current++) {
                sum += current;

                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer + 1;
    }
}
