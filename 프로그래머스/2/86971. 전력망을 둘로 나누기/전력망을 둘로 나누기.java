class Solution {

    static boolean[] visited;
    static boolean[][] map;
    static int count;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        map = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }

        for (int[] wire : wires) {
            visited = new boolean[n + 1];

            int a = wire[0];
            int b = wire[1];

            map[a][b] = false;
            map[b][a] = false;

            count = 0;
            dfs(1, n);
            int diff = Math.abs((n - count) - count);
            answer = Math.min(answer, diff);

            map[a][b] = true;
            map[b][a] = true;
        }

        return answer;
    }

    public void dfs(int start, int n) {
        visited[start] = true;
        count++;

        for (int i = 1; i <= n; i++) {
            if (map[start][i] && !visited[i]) {
                dfs(i, n);
            }
        }
    }
}