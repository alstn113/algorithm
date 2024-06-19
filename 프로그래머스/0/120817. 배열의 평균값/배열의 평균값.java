import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
}