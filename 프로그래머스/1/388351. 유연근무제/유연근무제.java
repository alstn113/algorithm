class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;

        for (int i=0; i<schedules.length; i++) {
            int schedule = getDate(schedules[i]) + 10;

            int startIdx = startday;
            int[] timelog = timelogs[i];

            boolean flag = false;
            for (int j=0; j<7; j++) {
                if (startIdx == 6 || startIdx == 7) {
                    startIdx += 1;
                    if (startIdx > 7) {
                        startIdx = 1;
                    
                    }   
                    continue;
                }

                if (getDate(timelog[j]) > schedule) {
                    flag = true;
                    break;
                }

                startIdx += 1;
                if (startIdx > 7) {
                    startIdx = 1;
                }
            }

            if(!flag) {
                result += 1;
            }
        }

        return result;
    }

    public int getDate(int date) {
        return (date / 100) * 60 + (date % 100);
    }
}