import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i=0; i<commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            
            int[] newArr = Arrays.copyOfRange(array, a-1, b);
            Arrays.sort(newArr);
            
            result[i] = newArr[c-1];
        }
        
        return result;
    }
}