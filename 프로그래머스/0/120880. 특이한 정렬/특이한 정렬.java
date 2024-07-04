import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    int u = Math.abs(a - n);
                    int v = Math.abs(b - n);
                    if (u == v) {
                        return b - a;
                    }
                    return u - v;
                })
                .mapToInt(v -> v)
                .toArray();
    }
}
