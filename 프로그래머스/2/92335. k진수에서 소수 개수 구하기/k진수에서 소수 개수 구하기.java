class Solution {
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        String[] split = s.split("0", -1);
        int answer = 0;
        for (String v : split) {
            if(v.isBlank()) continue;
            long longV = Long.parseLong(v);
            if (isPrime(longV)) {
                answer += 1;
            }
        }

        return answer;
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}