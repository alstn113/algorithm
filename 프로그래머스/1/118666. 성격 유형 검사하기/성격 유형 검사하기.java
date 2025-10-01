import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>(Map.of(
            "R", 0,
            "T", 0,
            "C", 0,
            "F", 0,
            "J", 0,
            "M", 0,
            "A", 0,
            "N", 0
        ));
        for (int i=0; i<survey.length; i++) {
            String a = survey[i].substring(0, 1);
            String b = survey[i].substring(1, 2);
            
            int v = choices[i];
            if (v < 3) {
                map.put(a, map.get(a) + 4-v);
            } else {
                map.put(b, map.get(b) + v-4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        String[][] types = new String[][] {
            { "R", "T" },
            { "C", "F" },
            { "J", "M" },
            { "A", "N" }
        };
        
        for (String[] type : types) {
            if (map.get(type[0]) >= map.get(type[1])) {
                sb.append(type[0]);
            } else {
                sb.append(type[1]);
            }
        }
        
        return sb.toString();
    }
}