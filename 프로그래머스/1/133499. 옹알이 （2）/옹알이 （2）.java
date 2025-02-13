import java.util.*;

class Solution {
    static String[] speaks = new String[] { "aya", "ye", "woo", "ma" };

    public int solution(String[] babbling) {
        int cnt = 0;
        for (String b : babbling) {
            if(canSpeak(b)) cnt += 1;
        }
        
        return cnt;
    }
    
    public boolean canSpeak(String b) {
        String prevSpeak = "";
        while(b.length() > 0) {
            boolean flag = false;
            
            for (String s : speaks) {
                if(prevSpeak.equals(s)) continue;
                if(b.startsWith(s)) {
                    b = b.substring(s.length());
                    prevSpeak = s;
                    flag = true;
                }
            }
            
            if(!flag) return false;
        }
        
        return true;
    }
}