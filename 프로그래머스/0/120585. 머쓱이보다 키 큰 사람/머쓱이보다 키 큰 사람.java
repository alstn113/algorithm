import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
            .filter(v -> v > height)
            .count();
    }
}