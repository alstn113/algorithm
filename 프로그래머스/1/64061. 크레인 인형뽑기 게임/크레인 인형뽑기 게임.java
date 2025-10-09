import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[j][i] != 0) {
                    arr[i] = j;
                    break;
                }
            }
        }
        
        
        Stack<Integer> st = new Stack<>();
        int result = 0;
        
        for (int move : moves) {
            if (arr[move-1] == -1) {
                continue;
            }
            
            int v = board[arr[move-1]][move-1];
            if (arr[move-1] == n-1) {
                arr[move-1] = -1;
            } else {
                arr[move-1] += 1;
            }
            
            if (!st.isEmpty() && v == st.peek()) {
                st.pop();
                result += 2;        
            } else {
                st.push(v);
            }
        }
        
        return result;
    }
}