import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] targets = new int[board.length];
        Arrays.fill(targets, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[j][i] != 0) {
                    targets[i] = j;
                    break;
                }
            }
        }

        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int m : moves) {
            int v = targets[m - 1];
            if (targets[m - 1] == -1) {
                continue;
            }

            int c = board[v][m - 1];
            if (!st.isEmpty() && c == st.peek()) {
                st.pop();
                answer += 2;
            } else {
                st.push(c);
            }

            if (targets[m - 1] == n - 1) {
                targets[m - 1] = -1;
            } else {
                targets[m - 1] += 1;
            }
        }

        return answer;
    }
}