import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 마지막 차에 자리가 있다. -> 마지막 차 시간
        // 마지막 차에 자리가 없다. -> 마지막 차의 마지막에 탄 사람 시간 - 1
        
        int start = getTime("09:00");
        List<Integer> times = new ArrayList<>();
        for (String tt : timetable) {
            times.add(getTime(tt));
        }
        Collections.sort(times);
        
        int last = 0;
        int idx = 0;
        int curM = m;
        for (int i=0; i<n; i++) {
            int limit = start  +  i * t;
            curM = m;
            
            while (curM > 0 && idx < times.size() && times.get(idx) <= limit) {
                last = times.get(idx);
                curM -= 1;
                idx += 1;
            }
        }
        
        if (curM > 0) {
            return getTime(start + (n-1) * t);
        }
         
        return getTime(last-1);
    }
    
    public int getTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);
        return h + m;
    }
    
    public String getTime(int time) {
        int h = time / 60;
        int m = time % 60;
        return String.format("%02d:%02d", h, m);
    }
}