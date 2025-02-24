class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n + 1];
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k -= 1;

        for (int i = 1; i <= n; i++) {
            int groupIndex = (int) (k / factorial[n - i]);
            k %= factorial[n - i];

            int index = 1;
            int count = 0;

            while (count <= groupIndex) {
                if (!visited[index]) {
                    count++;
                }
                if (count <= groupIndex) {
                    index++;
                }
            }

            visited[index] = true;
            answer[i - 1] = index;
        }

        return answer;
    }
}
