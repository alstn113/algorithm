import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            String v = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder binary = new StringBuilder(v);
            
            while (binary.length() < n) {
                binary.insert(0, "0");
            }
            
            binary = new StringBuilder(binary.toString().replaceAll("1", "#"));
            binary = new StringBuilder(binary.toString().replaceAll("0", " "));
            
            result[i] = binary.toString();
        }
        
        return result;
    }
}