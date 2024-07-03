import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        
        int a = (sides[0] + sides[1]) - sides[1] - 1;
        int b = sides[0];
            
        return a+b;
    }
}