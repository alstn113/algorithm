import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            char charA = a.charAt(n);
            char charB = b.charAt(n);

            if (charA > charB) return 1;
            else if (charB > charA) return -1;
            return a.compareTo(b);
        });
        
        return strings;
    }
}