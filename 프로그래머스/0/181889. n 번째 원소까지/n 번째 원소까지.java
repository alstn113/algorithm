import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
         // return Arrays.copyOf(num_list, n)
        return Arrays.copyOfRange(num_list, 0, n);
    }
}