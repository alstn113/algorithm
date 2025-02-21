import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i < order.length + 1; i++) {
            st.push(i);
            while (!st.isEmpty() && st.peek() == order[answer]) {
                answer += 1;
                st.pop();
            }
        }

        return answer;
    }
}