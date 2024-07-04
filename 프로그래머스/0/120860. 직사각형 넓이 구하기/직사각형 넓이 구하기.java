import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] a = dots[0];
        int[] b = dots[1];
        int[] c = dots[2];
        return Math.abs(b[1] - a[1]) * Math.abs(c[0] - a[0]);
    }
}