class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}