class Solution {

    int INF = (int) 1e9;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = (int) 1e9;
                }
            }
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int min = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            if (graph[i][s] == INF || graph[i][a] == INF || graph[i][b] == INF) {
                continue;
            }
            min = Math.min(min, graph[i][s] + graph[i][a] + graph[i][b]);
        }

        return min;
    }
}