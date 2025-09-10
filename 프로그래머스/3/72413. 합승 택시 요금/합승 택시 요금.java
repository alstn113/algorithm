import java.util.ArrayList;
import java.util.List;

class Solution {

    int INF = (int) 1e9;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // n은 노드 개수
        // s: start, a, b: end
        // fares

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = INF;
                }
            }
        }

        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];

            map[start][end] = weight;
            map[end][start] = weight;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int result = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            if (map[i][s] == INF || map[i][a] == INF || map[i][b] == INF) {
                continue;
            }
            result = Math.min(result, map[i][s] + map[i][a] + map[i][b]);
        }

        return result;
    }
}