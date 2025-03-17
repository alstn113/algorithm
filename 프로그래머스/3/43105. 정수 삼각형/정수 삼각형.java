class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        for (int i=n-2; i>-1; i--) {
            for (int j=0; j<triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}