class Solution {
    public int solution(String ineq, String eq, int n, int m) {
       boolean answer = false;
        if (ineq.equals(">") && eq.equals("="))
            answer = n >= m;
        else if (ineq.equals("<") && eq.equals("="))
            answer = n <= m;
        else if (ineq.equals(">") && eq.equals("!"))
            answer = n > m;
        else 
            answer = n < m;
        return answer ? 1 : 0;
    }
}