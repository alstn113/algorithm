class Solution {
    public int solution(int[] sticker) {
        int answer = 0;
        int n = sticker.length;
        answer = Math.max(answer, sticker[0] + calcMaxSum(2, n - 2, sticker));
        System.out.println(answer);
        answer = Math.max(answer, calcMaxSum(1, n - 3, sticker) + sticker[n - 1]);
        System.out.println(answer);
        answer = Math.max(answer, calcMaxSum(1, n - 2, sticker));
        System.out.println(answer);

        return answer;
    }

    public int calcMaxSum(int start, int end, int[] sticker) {
        if (end < start) {
            return 0;
        }

        int[][] arr = new int[end - start + 1][2];
        arr[0][0] = 0; // 추가하지 않음.
        arr[0][1] = sticker[start]; // 추가함.

        for (int i = start + 1; i <= end; i++) {
            int v = sticker[i];

            int arrIdx = i - start;
            arr[arrIdx][0] = Math.max(arr[arrIdx - 1][0], arr[arrIdx - 1][1]);
            arr[arrIdx][1] = arr[arrIdx - 1][0] + v;
        }

        return Math.max(arr[end - start][0], arr[end - start][1]);
    }
}