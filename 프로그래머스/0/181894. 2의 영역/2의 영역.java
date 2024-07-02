import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int s = -1;
        int e = -1;
        
        for (int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                if(s == -1) {
                    s = i;
                    e = i;
                } else {
                    e = i;
                }
            }
        }
        
        if(s == -1) {
            return new int[] { -1 };
        }
        return Arrays.copyOfRange(arr, s, e+1);
    }
}