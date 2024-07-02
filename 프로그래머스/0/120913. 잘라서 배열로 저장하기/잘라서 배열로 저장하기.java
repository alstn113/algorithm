class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() - 1) / n + 1];
        for (int i = 0; i < answer.length - 1; i++) {
            answer[i] = my_str.substring(i * n, (i + 1) * n);
        }
        answer[answer.length - 1] = my_str.substring((answer.length - 1) * n);
        return answer;
    }
}