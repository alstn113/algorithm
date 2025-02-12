import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            if(ch==' ') {
                sb.append(' ');
            }else if(ch>='a'&& ch<='z'){
                char c = (char)('a' + (ch+n-'a')%26);
                sb.append(c);
            }else {
                char c= (char)('A' + (ch+n-'A')%26);
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}