import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] freqX = new int[10];
        int[] freqY = new int[10];

        for (char c : X.toCharArray()) {
            freqX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            freqY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(freqX[i], freqY[i]);
            for (int j = 0; j < commonCount; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) return "-1";        
        if (sb.charAt(0) == '0') return "0";      

        return sb.toString();
    }
}
