import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int result = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<A.length; i++) {
            int v = A[i] * B[A.length - i - 1];
            result += v;
        }

        return result;
    }
}