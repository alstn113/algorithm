import java.util.*;

class Solution {
    
    int INF = (int) 1e9;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] routes = new int[n+1][n+1];
        for (int i=0; i<n+1; i++) {
            Arrays.fill(routes[i], INF);
        }
        
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                if (i == j) routes[i][j] = 0;
            }
        }
        
        for (int[] fare : fares) {
            int af = fare[0];
            int bf = fare[1];
            int cost = fare[2];
            
            routes[af][bf] = cost;
            routes[bf][af] = cost;
        }
        
        for (int k=1; k<n+1; k++) {
            for (int i=1; i<n+1; i++) {
                for (int j=1; j<n+1; j++) {
                    routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
                }
            }
        }
        
        int result = INF;
        for (int i=1; i<n+1; i++) {
            int sc = routes[i][s];
            int ac = routes[i][a];
            int bc = routes[i][b];
            if (sc == INF || ac == INF || bc == INF) continue;
            
            int cost = sc + ac + bc;
            result = Math.min(result, cost);
        }
        
        return result;
    }
}