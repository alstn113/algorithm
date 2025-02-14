import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int[] arrIdx = new int[board[0].length];
        Arrays.fill(arrIdx, board.length);

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0 && arrIdx[i] == board.length) {
                    arrIdx[i] = j;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arrIdx));

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int idx = arrIdx[move - 1];
            if(idx == board.length) {
                continue;
            }

            arrIdx[move - 1]++;
            int v = board[idx][move - 1];

            if (!stack.isEmpty() && stack.peek() == v) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(v);
            }

        }

        return answer;
    }
}