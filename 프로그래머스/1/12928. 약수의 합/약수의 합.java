class Solution {
    public int solution(int n) {
        int result = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                if (i*i == n) {
                    result += i;
                } else {
                    result += i + n/i;                    
                }
            }
        }
        
        return result;
    }
}