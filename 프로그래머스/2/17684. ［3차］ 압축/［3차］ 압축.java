import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static String alphabets = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int[] solution(String msg) {
        // 초기 등록
        Map<String, Integer> dic = new HashMap<>();
        int cnt = 0;
        for (int i = 1; i < alphabets.length(); i++) {
            String s = String.valueOf(alphabets.charAt(i));
            dic.put(s, i);
            cnt += 1;
        }

        List<Integer> answer = new ArrayList<>();

        String tmp = String.valueOf(msg.charAt(0));
        for (int i = 1; i < msg.length(); i++) {
            String next = tmp + msg.charAt(i);
            if (dic.containsKey(next)) {
                tmp = next;
                continue;
            }

            answer.add(dic.get(tmp));
            cnt += 1;
            dic.put(next, cnt);
            i -= 1;
            tmp = "";
        }

        if (!tmp.isEmpty()) {
            answer.add(dic.get(tmp));
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}