import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todate = getDate(today);
        Map<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            String[] split = t.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int date = getDate(split[0]);
            String term = split[1];
            int termM = map.get(term);

            if (date + termM * 28 <= todate) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(v -> v).toArray();
    }

    public int getDate(String date) {
        String[] split = date.split("\\.");
        int y = Integer.parseInt(split[0]) * 12 * 28;
        int m = Integer.parseInt(split[1]) * 28;
        int d = Integer.parseInt(split[2]);
        return y + m + d;
    }
}