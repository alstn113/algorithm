class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        int answer = 100000;

        while (start <= end) {
            int mid = (start + end) / 2;
            long totalTime = calcTime(diffs, times, mid);

            if (totalTime > limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }

    public long calcTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                long v = (long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                totalTime += v;
            }
        }

        return totalTime;
    }
}
