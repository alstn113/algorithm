import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int[] canWinPlayers = new int[n];

        int i = 0;
        for (int j = 0; j < n; j++) {
            while (i < n) {
                if (A[j] < B[i]) {
                    canWinPlayers[j] = n - i;
                    break;
                }
                i++;
            }
        }

        int tmp = 0;
        int answer = 0;
        for (int v = n - 1; v >= 0; v--) {
            if (canWinPlayers[v] - tmp > 0) {
                tmp += 1;
                answer += 1;
            }
        }

        return answer;
    }
}