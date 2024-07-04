import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
            int q = query[i];
            if (i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, 0, q + 1);
            } else {
                arr = Arrays.copyOfRange(arr, q, arr.length);
            }
        }

        return arr;
    }
}