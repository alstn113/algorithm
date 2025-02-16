class Solution {
    static int count = 0;

    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, new int[5], 0, n, q, ans);
        return count;
    }

    public void dfs(int start, int[] current, int depth, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isValid(current, q, ans)) {
                count++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            current[depth] = i;
            dfs(i + 1, current, depth + 1, n, q, ans);
        }
    }

    private boolean isValid(int[] candidate, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int matches = 0;
            for (int num : candidate) {
                for (int j = 0; j < 5; j++) {
                    if (num == q[i][j]) {
                        matches++;
                        break;
                    }
                }
            }
            if (matches != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
