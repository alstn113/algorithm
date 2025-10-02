class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 누적 시간이 가장 큰 광고의 시작 시간을 구하라.
        // 동일한게 많으면 앞에 있는 것부터.

        int playSeconds = getSeconds(play_time);
        int advSeconds = getSeconds(adv_time);

        int[] arr = new int[playSeconds + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = getSeconds(split[0]);
            int end = getSeconds(split[1]);

            arr[start] += 1;
            arr[end] -= 1;
        }

        long sum = 0;
        int right = 0;
        int rightIdx = 0;
        while (rightIdx < advSeconds) {
            right += arr[rightIdx];
            sum += right;
            rightIdx += 1;
        }
        long max = sum;
        int answer = 0;

        int left = 0;
        int leftIdx = 0;
        int i = 0;
        while (i < arr.length - advSeconds) {
            left += arr[leftIdx];
            sum -= left;
            leftIdx += 1;

            right += arr[rightIdx];
            sum += right;
            rightIdx += 1;

            i += 1;


            if (sum > max) {
                max = sum;
                answer = leftIdx;
            }
        }

        return getSecondsString(answer);
    }

    public int getSeconds(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60 * 60;
        int m = Integer.parseInt(split[1]) * 60;
        return h + m + Integer.parseInt(split[2]);
    }

    public String getSecondsString(long seconds) {
        int h = (int) (seconds / 3600);
        int hremain = (int) (seconds % 3600);
        int m = hremain / 60;
        int s = hremain % 60;

        return String.format("%02d:%02d:%02d", h, m, s);

    }
}