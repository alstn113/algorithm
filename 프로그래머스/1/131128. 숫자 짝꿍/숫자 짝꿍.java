import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String solution = solution("100", "2345");
        System.out.println(solution);
    }

    public static String solution(String X, String Y) {
        Map<Integer, Integer> dic1 = new HashMap<>();
        Map<Integer, Integer> dic2 = new HashMap<>();

        for (char c : X.toCharArray()) {
            Integer v = Integer.parseInt(String.valueOf(c));
            dic1.put(v, dic1.getOrDefault(v, 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            Integer v = Integer.parseInt(String.valueOf(c));
            dic2.put(v, dic2.getOrDefault(v, 0) + 1);
        }

        System.out.println(dic1);
        System.out.println(dic2);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : dic1.entrySet()) {
            Integer key = entry.getKey();
            Integer dic2Value = dic2.getOrDefault(key, 0);

            if (dic2Value > 0) {
                for (int i = 0; i < Math.min(entry.getValue(), dic2Value); i++) {
                    result.add(key);
                }
            }
        }

        if (result.isEmpty()) {
            return "-1";
        }

        Collections.sort(result, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer);
        }

        if (sb.toString().startsWith("0")) {
            return "0";
        }
        return sb.toString();
    }
}