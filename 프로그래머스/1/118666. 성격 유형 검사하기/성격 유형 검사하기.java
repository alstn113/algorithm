import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> dic = new HashMap<>(Map.of(
                "R", 0,
                "T", 0,
                "C", 0,
                "F", 0,
                "J", 0,
                "M", 0,
                "A", 0,
                "N", 0
        ));

        for (int i = 0; i < survey.length; i++) {
            String[] s = survey[i].split("");

            String a = s[0];
            String b = s[1];

            int choice = choices[i] -1;

            if (choice < 3) {
                dic.put(a, dic.get(a) + 3 - choice);
            } else if (choice > 3) {
                dic.put(b, dic.get(b) + choice - 3);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dic.get("R") >= dic.get("T"))  sb.append("R");
        else sb.append("T");
        
        if (dic.get("C") >= dic.get("F"))  sb.append("C");
        else sb.append("F");
        
        if (dic.get("J") >= dic.get("M"))  sb.append("J");
        else sb.append("M");
        
        if (dic.get("A") >= dic.get("N"))  sb.append("A");
        else sb.append("N");
        
        return sb.toString();
    }
}