class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] split = lines[i].split(" ");
            int end = getTime(split[1]);
            double sec = Double.parseDouble(split[2].substring(0, split[2].length() - 1));
            int duration = (int) (sec * 1000);
            int start = end - duration + 1;
            times[i][0] = start;
            times[i][1] = end;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int startWindow = times[i][1];
            int endWindow = startWindow + 999;

            int count = 0;
            for (int j = 0; j < n; j++) {
                int end = times[j][1];
                int start = times[j][0];
                if (startWindow <= end && start <= endWindow) {
                    count += 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        String[] secSplit = split[2].split("\\.");
        int s = Integer.parseInt(secSplit[0]);
        int ms = Integer.parseInt(secSplit[1]);
        return (h * 3600 + m * 60 + s) * 1000 + ms;
    }
}
