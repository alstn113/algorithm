import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;
        int answer = 0;

        while (bIdx < n) {
            if (A[aIdx] < B[bIdx]) {
                answer += 1;
                aIdx += 1;
            }
            bIdx += 1;
        }

        return answer;
    }
}