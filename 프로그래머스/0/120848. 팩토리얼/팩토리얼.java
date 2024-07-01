class Solution {
    public int solution(int n) {
        int answer = 1;
        int factorial = 1;

        while(n >= factorial) {
            answer ++;
            factorial *= answer;
        }
        return answer - 1;
    }
}