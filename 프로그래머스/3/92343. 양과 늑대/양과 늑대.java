import java.util.ArrayList;
import java.util.List;

class Solution {
    int result = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
        }

        List<Integer> initial = new ArrayList<>();
        initial.add(0);
        dfs(graph, info, initial, 0, 0);

        return result;
    }

    public void dfs(List<List<Integer>> graph, int[] info, List<Integer> able, int sheep, int wolf) {
        for (Integer target : new ArrayList<>(able)) {
            int newSheep = info[target] == 0 ? sheep + 1 : sheep;
            int newWolf = info[target] == 1 ? wolf + 1 : wolf;

            if (newWolf >= newSheep) {
                continue;
            }

            able.remove(target);
            able.addAll(graph.get(target));

            result = Math.max(result, newSheep);
            dfs(graph, info, new ArrayList<>(able), newSheep, newWolf);

            able.removeAll(graph.get(target));
            able.add(target);
        }
    }
}