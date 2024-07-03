class Solution {
    public int[][] solution(int[][] arr) {
        int max = Math.max(arr.length, arr[0].length);
        int[][] result = new int[max][max];
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                result[i][j] = arr[i][j];                
            }
        }
        return result;
    }
}