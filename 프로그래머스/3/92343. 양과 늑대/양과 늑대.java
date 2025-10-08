import java.util.*;

class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    int max = 1;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }
        
        dfs(1, 0, new ArrayList<>(graph.get(0)), info);
        
        return max;
    }
    
    public void dfs(int s, int w, List<Integer> nodes, int[] info) {
        for (int node : nodes) {
            int newSheep = info[node] == 0  ? 1 : 0;
            int newWolf = info[node] == 1 ? 1 : 0;
            
            if (s + newSheep <= w + newWolf) {
                continue;
            } 
            
            List<Integer> copy = new ArrayList<>(nodes);
            copy.addAll(graph.get(node));
            copy.remove(Integer.valueOf(node));
            
            max = Math.max(s + newSheep, max);
            
            dfs(s + newSheep, w + newWolf, copy, info);
        }
    } 
}