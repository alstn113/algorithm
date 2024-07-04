class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            answer += 1;
            while(answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer += 1;
            }
        }
        return answer;
    }
}