class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);

            if (row >= col) {
                answer[(int) (i - left)] = row + 1;
                continue;
            }
            answer[(int) (i - left)] = col + 1;
        }

        return answer;
    }
}