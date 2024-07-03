import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();
        for (String s : picture) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < picture[0].length(); j++) {
                tmp.append(String.valueOf(s.charAt(j)).repeat(k));
            }
            for (int m = 0; m < k; m++) {
                answer.add(tmp.toString());
            }
        }
        return answer.toArray(String[]::new);
    }
}