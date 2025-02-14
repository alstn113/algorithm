import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 현재 날짜
        int current = getDate(today);

        // "A 6" 분리 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        // 정답 리스트
        List<Integer> result = new ArrayList<>();

        // 보관 날짜 처리
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");

            int v = getDate(split[0]);
            String type = split[1];

            int n = v + termMap.get(type) * 28;

            if (current > n - 1) {
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(v -> v).toArray();
    }

    public int getDate(String today) {
        String[] ts = today.split("\\.");
        int y = Integer.parseInt(ts[0]);
        int m = Integer.parseInt(ts[1]);
        int d = Integer.parseInt(ts[2]);

        return 12 * 28 * y + 28 * m + d;
    }
}