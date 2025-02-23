import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();
        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }

        for (int num = 100; num < 1001; num++) {
            if (!map.containsKey(num)) {
                continue;
            }

            long cnt = map.get(num);

            if (cnt >= 2) {
                System.out.println(num);
                answer += cnt * (cnt - 1) / 2;
            }

            int next = num * 3 / 2;
            if (map.containsKey(next) && num * 3 % 2 == 0) {
                System.out.println(num + " " + next);
                answer += cnt * map.get(next);
            }

            next = num * 4 / 3;
            if (map.containsKey(next) && num * 4 % 3 == 0) {
                System.out.println(num + " " + next);
                answer += cnt * map.get(next);
            }

            next = num * 2;
            if (map.containsKey(next) && num <= 500) {
                System.out.println(num + " " + next);
                answer += cnt * map.get(next);
            }
        }

        return answer;
    }
}