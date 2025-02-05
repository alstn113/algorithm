package algorithm.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 시간 복잡도: O(V + E) - V: 정점의 수, E: 간선의 수
public class BFS {

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

        bfs(1); // 1부터 시작
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
