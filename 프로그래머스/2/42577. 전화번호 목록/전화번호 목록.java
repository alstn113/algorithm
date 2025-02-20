import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 1);
        }

        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                String sub = s.substring(0, i);
                if (map.containsKey(sub)) {
                    return false;
                }
            }
        }

        return true;
    }
}