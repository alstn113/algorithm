import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int cnt = 0;
        Map<Integer, Integer> dic = new HashMap<>();

        for (Integer t : topping) {
            if (dic.containsKey(t)) {
                dic.put(t, dic.get(t) + 1);
            } else {
                dic.put(t, 1);
                cnt += 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (Integer t : topping) {
            set.add(t);
            int v = dic.get(t) - 1;
            dic.put(t, v);
            if (v == 0) {
                cnt -= 1;
            }

            if (set.size() == cnt) {
                answer += 1;
            }
        }

        return answer;
    }
}