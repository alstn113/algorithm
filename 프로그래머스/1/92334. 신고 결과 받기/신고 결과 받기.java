import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 횟수 초기화
        Map<String, Integer> reported = new HashMap<>();
        for (String id : id_list) {
            reported.put(id, 0);
        }

        // 신고 기록 초기화
        Map<String, List<String>> reportLog = new HashMap<>();
        for (String id : id_list) {
            reportLog.put(id, new ArrayList<>());
        }

        // 신고 처리
        for (String r : report) {
            String[] split = r.split(" ");

            String from = split[0];
            String to = split[1];

            List<String> reportList = reportLog.get(from);
            if (!reportList.contains(to)) {
                reportList.add(to);
                reported.put(to, reported.get(to) + 1);
            }
        }

        int[] result = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            int count = 0;
            for (String r : reportLog.get(id_list[i])) {
                if (reported.get(r) >= k) {
                    count += 1;
                }
            }
            result[i] = count;
        }

        return result;
    }
}