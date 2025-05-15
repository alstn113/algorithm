package algorithm.DFS;

import java.util.ArrayList;
import java.util.List;

// 시간 복잡도: O(V + E) - V: 정점의 수, E: 간선의 수
// 문제 유형
// 1. 영역 탐색, 연결 요소 세기,
// 2. 모든 경로 탐색, 백트래킹
// 3. 영역 채우기
// 4. 재귀적 성질이 있는 문제
public class DFS {

    static boolean[] visited = new boolean[9];
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] edges = {
            {1, 2},
            {1, 3},
            {1, 8},
            {2, 7},
            {3, 4},
            {3, 5},
            {4, 5},
            {6, 7},
            {7, 8}
    };

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
        }

        dfs(1); // 1부터 시작
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
