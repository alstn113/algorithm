public class DFS {

    static void dfs(int nodeIndex, boolean[] visited, int[][] graph) {
        visited[nodeIndex] = true;

        for (int node : graph[nodeIndex]) {
            if (!visited[node]) {
                dfs(node, visited, graph);
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

        dfs(0, visited, graph);
    }
}
