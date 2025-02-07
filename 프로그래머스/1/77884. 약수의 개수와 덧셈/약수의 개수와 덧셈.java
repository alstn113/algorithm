class Solution {
    public int solution(int left, int right) {
        int result = 0;
        
        for (int i=left; i<=right; i++) {
            if (isEven(i)) result += i;
            else result -= i;
        }
        
        return result;
    }
    
    public boolean isEven(int n) {
        int cnt = 0;
        
        for (int i=1; i<=n; i++) {
            if (n%i == 0) {
                cnt += 1;
            }
        }
        
        return cnt % 2 == 0;
    }
}