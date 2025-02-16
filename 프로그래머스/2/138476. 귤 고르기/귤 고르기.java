import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int t : tangerine) {
            dic.put(t, dic.getOrDefault(t, 0) + 1);
        }

        List<Integer> sizes = dic.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int result = 0;
        for (Integer size : sizes) {
            k -= size;
            result += 1;

            if (k <= 0) {
                break;
            }
        }

        return result;
    }
}