class Solution {
    
    static int cnt = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            
            cnt += 1;
            dfs(i, computers);
        }
        
        return cnt;
    }
    
    public void dfs(int target, int[][] computers) {
        visited[target] = true;
        
        int[] connects = computers[target];
        for (int i=0; i<connects.length; i++) {
            if (connects[i] == 0) continue;
            if (visited[i]) continue;
            
            dfs(i, computers);
        }
    }
}