class Solution {
    public int solution(int n, int k) {
        String nString = Integer.toString(n, k);
        
        String[] split = nString.split("0");
        int answer = 0;
        for (String s : split) {
            if (s.isBlank()) {
                continue;
            }
            Long v = Long.parseLong(s);
            if (isPrime(v)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        
        for (long i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}