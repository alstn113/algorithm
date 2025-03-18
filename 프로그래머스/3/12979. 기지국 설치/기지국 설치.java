class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        int end;

        for (int cur : stations) {
            end = inRange(cur - w - 1, 1, n);
            answer += Math.ceil((double) (end - start + 1) / (2 * w + 1));
            start = inRange(cur + w + 1, 1, n);
        }
        
        answer += Math.ceil((double) (n - start + 1) / (2 * w + 1));

        return answer;
    }

    public int inRange(int cur, int min, int max) {
        return Math.min(Math.max(cur, min - 1), max + 1);
    }
}