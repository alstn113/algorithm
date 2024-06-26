import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int k) {
        return IntStream.rangeClosed(1, n)
            .filter(i -> i % k == 0)
            .toArray();
    }
}
