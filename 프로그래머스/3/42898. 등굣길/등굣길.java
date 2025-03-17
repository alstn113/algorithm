class Solution {
    
    static int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        arr[0][0] = 0;
        for (int[] puddle : puddles) {
            int a = puddle[0];
            int b = puddle[1];
            arr[b-1][a-1] = -1;
        }
        
        for (int i=1; i<n; i++) {
            if (arr[i][0] == -1) break;
            arr[i][0] = 1;
        }
        
        for (int j=1; j<m; j++) {
            if (arr[0][j] == -1) break;
            arr[0][j] = 1; 
        }
        
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (arr[i][j] == -1) continue;
                if (arr[i-1][j] != -1) arr[i][j] += arr[i-1][j];
                if (arr[i][j-1] != -1) arr[i][j] += arr[i][j-1];
                arr[i][j] %= MOD;
            }
        }
        
        return arr[n-1][m-1];
    }
}