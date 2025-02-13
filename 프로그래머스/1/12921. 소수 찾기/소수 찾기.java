import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i=2; i<=n; i++) {
            if(isPrime(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }
    
    public boolean isPrime(int n) {
        for (int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }
        
        return true;
    }
}