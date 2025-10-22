package kakao.s2;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] signals) {
        int[] arr = new int[signals.length];

        int n = 1;
        for (int i = 0; i < signals.length; i++) {
            int v = Arrays.stream(signals[i]).sum();
            arr[i] = v;
            n = lcm(v, n);
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < signals.length; j++) {
                int cur = i % arr[j];
                if (!(signals[j][0] - 1 < cur && cur < signals[j][0] + signals[j][1])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i + 1;
            }
        }

        return answer;
    }

    public int lcm(int n, int m) {
        if (n > m) {
            return (n * m) / gcd(n, m);
        }
        return (n * m) / gcd(m, n);
    }

    public int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test1 = s.solution(new int[][]{{2, 1, 2}, {5, 1, 1}});
        boolean test1Correct = test1 == 13;
        int test2 = s.solution(new int[][]{{2, 3, 2}, {3, 1, 3}, {2, 1, 1}});
        boolean test2Correct = test2 == 11;
        int test3 = s.solution(new int[][]{{3, 3, 3}, {5, 4, 2}, {2, 1, 2}});
        boolean test3Correct = test3 == 193;
        int test4 = s.solution(new int[][]{{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}});
        boolean test4Correct = test4 == -1;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
        System.out.println("test3: " + test3Correct);
        System.out.println("test4: " + test4Correct);
    }
}
