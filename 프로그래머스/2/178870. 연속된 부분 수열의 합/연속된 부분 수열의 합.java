class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int sum = 0;
        int end = 0;

        int left = -1;
        int right = -1;

        for (int start = 0; start < n; start++) {
            while (sum < k && end < n) {
                sum += sequence[end];
                end += 1;
            }

            if (sum == k) {
                if (left == -1) {
                    left = start;
                    right = end - 1;
                } else {
                    if (right - left > end - 1 - start) {
                        left = start;
                        right = end - 1;
                    }
                }
            }
            
            sum -= sequence[start];
        }

        return new int[]{left, right};
    }
}