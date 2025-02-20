import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }
    
    public void dfs(int current, int[][] dungeons, int count) {        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (dungeons[i][0] <= current) {
                visited[i] = true;
                dfs(current - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            } 
        }
        
        max = Math.max(max, count);
    }
}
