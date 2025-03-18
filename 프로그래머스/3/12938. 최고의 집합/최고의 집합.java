class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        int cnt = s % n;
        int idx = n - 1;
        while (cnt > 0) {
            answer[idx] += 1;
            idx -= 1;
            cnt -= 1;
        }

        return answer;
    }
}