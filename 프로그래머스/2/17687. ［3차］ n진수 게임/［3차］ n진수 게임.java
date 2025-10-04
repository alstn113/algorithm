import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(sb.toString().length() < t * m) {
            sb.append(Integer.toString(i, n));
            i += 1;
        }
        
        String target = sb.toString();
        StringBuilder result = new StringBuilder();
        int k=0;
        while(k<t) {
            int idx = k*m + (p-1);
            result.append(target.charAt(idx));
            k += 1;
        }
        
        return result.toString().toUpperCase();
    }
}