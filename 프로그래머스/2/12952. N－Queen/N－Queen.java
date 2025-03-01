class Solution {

    private int count = 0; // 가능한 배치 경우의 수

    public int solution(int n) {
        int[] columns = new int[n];
        backtrack(columns, n, 0);
        return count;
    }

    private void backtrack(int[] columns, int n, int row) {
        if (row == n) {
            count += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPossible(columns, row, i)) {
                columns[row] = i;
                backtrack(columns, n, row + 1);
            }
        }
    }

    private boolean isPossible(int[] columns, int row, int col) {
        for (int prev = 0; prev < row; prev++) {
            if (columns[prev] == col || Math.abs(columns[prev] - col) == row - prev) {
                return false;
            }
        }

        return true;
    }
}
