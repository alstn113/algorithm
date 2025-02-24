public class Solution {

    public long solution(int n, int[] times) {
        long left = 1; // 최소 시간
        long right = (long) n * times[0]; // 최대 시간

        while (left <= right) {
            long mid = (left + right) / 2;

            long peopleCount = getPeopleCount(mid, times);
            if (peopleCount >= n) {
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }

        return left;
    }

    private static long getPeopleCount(long time, int[] times) {
        long count = 0;
        for (int t : times) {
            count += time / t;
        }
        return count;
    }
}
