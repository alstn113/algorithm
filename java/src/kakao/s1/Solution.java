package kakao.s1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String message, int[][] spoiler_ranges) {
        Map<String, Integer> map1 = new HashMap<>(); // 전체 문자 - 동일 포함
        Map<String, Integer> map2 = new HashMap<>(); // 스포일러 지정 문자 - 동일 포함

        int n = message.length();
        int[][] arr = new int[20000][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        int start = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!flag && message.charAt(i) != ' ') {
                start = i;
                flag = true;
                continue;
            }

            if (flag && message.charAt(i) == ' ') {
                flag = false;

                for (int j = start; j < i; j++) {
                    arr[j] = new int[]{start, i - 1};
                }
                map1.merge(message.substring(start, i), 1, Integer::sum);
            }
        }
        if (flag) {
            for (int j = start; j < n; j++) {
                arr[j] = new int[]{start, n - 1};
            }
            map1.merge(message.substring(start, n), 1, Integer::sum);
        }

        for (int[] sr : spoiler_ranges) {
            int s = sr[0];
            int e = sr[1];

            boolean f = false;
            for (int i = s; i <= e; i++) {
                if (message.charAt(i) != ' ') {
                    if (!f) {
                        f = true;
                        int[] target = arr[i];
                        int s1 = target[0];
                        int s2 = target[1];
                        map2.merge(message.substring(s1, s2 + 1), 1, Integer::sum);
                    }
                } else {
                    f = false;
                }
            }
        }

        int answer = 0;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String target = entry.getKey();
            if (map1.getOrDefault(target, 0) > entry.getValue()) {
                continue;
            }
            answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int test1 = solution.solution(
                "here is muzi here is a secret message",
                new int[][]{{0, 3}, {23, 28}}
        );
        boolean test1Correct = test1 == 1;

        int test2 = solution.solution(
                "my phone number is 01012345678 and may i have your phone number",
                new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}}
        );
        boolean test2Correct = test2 == 4;

        System.out.println("----- TEST -----");
        System.out.println("test1: " + test1Correct);
        System.out.println("test2: " + test2Correct);
    }
}
