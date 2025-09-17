import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // n 운영횟수
        // t 운행간격
        // m 탈 수 있는 사람 수
        List<Integer> times = new ArrayList<>();
        for (String time : timetable) {
            times.add(getTime(time));
        }
        times.sort((o1, o2) -> o1 - o2);

        int start = getTime("09:00");
        int idx = 0;
        int last = 0;
        int mIdx = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            time = start + i * t;
            mIdx = 0;
            while (idx < times.size() && mIdx < m) {
                int v = times.get(idx);
                if (v <= time) {
                    mIdx += 1;
                    last = v;
                    idx += 1;
                } else {
                    break;
                }
            }
        }

        // 막차의 자리가 남아 있는 경우
        if (mIdx < m) {
            return getTime(time);
        }

        // 막차의 자리가 없는 경우
        if (idx - 1 == -1) {
            return getTime(time);
        }
        return getTime(last - 1);
    }

    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);

        return h + m;
    }

    public String getTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}