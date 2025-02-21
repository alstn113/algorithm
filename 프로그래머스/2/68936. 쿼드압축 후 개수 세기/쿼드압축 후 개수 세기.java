class Solution {

    static int one = 0;
    static int zero = 0;

    public int[] solution(int[][] arr) {
        int len = arr.length;

        dfs(arr, 0, 0, len);

        return new int[]{zero, one};
    }

    public void dfs(int[][] arr, int x, int y, int len) {
        int start = arr[x][y];

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (start != arr[i][j]) {
                    dfs(arr, x, y, len / 2);
                    dfs(arr, x + len / 2, y, len / 2);
                    dfs(arr, x, y + len / 2, len / 2);
                    dfs(arr, x + len / 2, y + len / 2, len / 2);
                    return;
                }
            }
        }

        if (start == 0) {
            zero += 1;
        } else {
            one += 1;
        }
    }
}