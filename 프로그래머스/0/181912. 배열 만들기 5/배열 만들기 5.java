import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < intStrs.length; i++) {
            String str = String.valueOf(intStrs[i]);
            String sub = str.substring(s, s + l);
            int num = Integer.parseInt(sub);
            if (num > k) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }
}