class Solution {
    public int solution(int n) {
        int result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i == n) {
                result++;
            } else if (n % i == 0) {
                result += 2;
            }
        }
        return result;
    }
}
