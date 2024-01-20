import java.util.LinkedList;
import java.util.Queue;

class BFS {
    static void bfs(int start, boolean[] visited, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int i = 0; i < graph[v].length; i++) {
                if (!visited[graph[v][i]]) {
                    queue.add(graph[v][i]);
                    visited[graph[v][i]] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean[] visited = new boolean[7];

        int[][] graph = {
                { 1, 2, 3 },
                { 0, 4, 5 },
                { 0, 6 },
                { 0, 6 },
                { 1 },
                { 1 },
                { 2, 3 },
        };

        bfs(0, visited, graph);
    }
}
