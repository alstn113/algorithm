import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(v -> v * 2).toArray();
    }
}