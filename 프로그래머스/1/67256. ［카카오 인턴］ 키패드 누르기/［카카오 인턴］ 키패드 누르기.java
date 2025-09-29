import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> map = Map.of(
            1, new int[] {0, 0},
            4, new int[] {1, 0},
            7, new int[] {2, 0},
            2, new int[] {0, 1},
            5, new int[] {1, 1},
            8, new int[] {2, 1},
            0, new int[] {3, 1},
            3, new int[] {0, 2},
            6, new int[] {1, 2},
            9, new int[] {2, 2}
        );
        
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        
        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7 ) {
                left = map.get(n);
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = map.get(n);
                sb.append("R");
            } else {
                int[] target = map.get(n);
                int a = Math.abs(target[0] - left[0]) + Math.abs(target[1] - left[1]);
                int b = Math.abs(target[0] - right[0]) + Math.abs(target[1] - right[1]);
                
                if (a < b) {
                    left = target;
                    sb.append("L");
                } else if (a > b) {
                    right = target;
                    sb.append("R");
                } else if (hand.equals("right")) {
                    right = target;
                    sb.append("R");
                } else {
                    left = target;
                    sb.append("L");
                }
            }
        }
        
        return sb.toString();
    }
}