import java.util.*;

class Solution {
    public String solution(String rsp) {
    Map<String, String> win = new HashMap<>();
        win.put("2", "0");
        win.put("0", "5");
        win.put("5", "2");

        StringBuilder sb = new StringBuilder();
        for (char c : rsp.toCharArray()) {
            sb.append(win.get(String.valueOf(c)));
        }
        return sb.toString();
    }
}