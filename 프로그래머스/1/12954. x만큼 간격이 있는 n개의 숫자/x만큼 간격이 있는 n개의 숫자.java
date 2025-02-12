class Solution {
    public long[] solution(int x, int n) {
        long[] result = new long[n];
        
        for (int i=0; i<n; i++) {
            result[i] = (long) x * (i+1);
        }
        
        return result;
    }
}