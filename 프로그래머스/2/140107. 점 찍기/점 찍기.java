class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long v = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += v / k + 1;
        }

        return answer;
    }
}