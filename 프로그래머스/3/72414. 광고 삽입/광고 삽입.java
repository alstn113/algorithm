class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] play = new int[getTime(play_time) + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            int start = getTime(split[0]);
            int end = getTime(split[1]);
            play[start] += 1;
            play[end] -= 1;
        }

        int adv = getTime(adv_time);

        long result = 0;
        int rleft = 0;

        long cur = 0;
        int right = 0;
        int rightSum = 0;

        while (right < adv) {
            rightSum += play[right];
            cur += rightSum;
            right++;
        }

        result = cur;

        int left = 0;
        int leftSum = 0;

        while (right < play.length) {
            rightSum += play[right];
            cur += rightSum; 
            right++;

            leftSum += play[left];
            cur -= leftSum; 
            left++;

            if (cur > result) {
                result = cur;
                rleft = left;
            }
        }

        return getTime(rleft);
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 3600;
        int m = Integer.parseInt(split[1]) * 60;
        int s = Integer.parseInt(split[2]);
        return h + m + s;
    }

    public String getTime(int time) {
        int h = time / 3600;
        int mtos = time % 3600;
        int m = mtos / 60;
        int s = mtos % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
