import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int v1 = (int) Math.pow(sum, 2);
        int v2 = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        return v1 > v2 ? 1 : 0;
    }
}