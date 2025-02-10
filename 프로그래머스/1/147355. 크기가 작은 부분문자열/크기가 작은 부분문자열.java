import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int result = 0;
        Long pLong = Long.parseLong(p);
        
        for (int i=0; i<t.length() - p.length() + 1; i++) {
            String v = t.substring(i, i+p.length());
            Long vLong = Long.parseLong(v);
            
            if (pLong >= vLong) {
                result += 1;
            }
        }
        
        return result;
    }
}