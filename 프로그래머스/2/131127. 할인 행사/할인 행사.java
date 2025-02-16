import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> check = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            check.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> currentCount = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                currentCount.put(discount[j], currentCount.getOrDefault(discount[j], 0) + 1);
            }
            
            if (currentCount.equals(check)) {
                answer++;
            }
        }

        return answer;
    }
}
