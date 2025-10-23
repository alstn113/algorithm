import java.util.*;

class Solution {

    int INF = (int) 1e9;
    List<List<Integer>> perm = new ArrayList<>();
    
    public int solution(int n, int[] weak, int[] dist) {
        boolean[] visited = new boolean[dist.length];
        dfs(0, new ArrayList<>(), 0, dist, visited);
        
        int[] weak2 = new int[weak.length * 2];
        for (int i=0; i<weak.length; i++) {
            weak2[i] = weak[i];
            weak2[i+weak.length] = weak[i] + n;
        }
        
        int answer = INF;
        
        for (List<Integer> p : perm) {
            
            for (int i=0; i<weak.length; i++) {
                int dpoint = 0; 
                int w=0;
                while (w < weak.length && dpoint < p.size()) {
                    int d = weak2[i+w] + p.get(dpoint);
                    w += 1;
                    dpoint += 1;
                    
                    while (w < weak.length && weak2[i+w] <= d) {
                        w += 1;
                    }
                }
                
                if (w == weak.length) {
                    answer = Math.min(answer, dpoint);
                }
            }            
            
        }
        
        if (answer == INF) {
            return -1;
        }
        
        return answer;
    }
    
    public void dfs(int cnt, List<Integer> cur, int start, int[] dist, boolean[] visited) {
        if (cnt == dist.length) {
            perm.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i=0; i<dist.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            cur.add(dist[i]);
            visited[i] = true;
            dfs(cnt+1, cur, i+1, dist, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}