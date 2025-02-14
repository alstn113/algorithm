import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {
        int[] l = {3, 0};
        int[] r = {3, 2};

        Map<Integer, int[]> dic = Map.of(
                1, new int[]{0, 0},
                2, new int[]{0, 1},
                3, new int[]{0, 2},
                4, new int[]{1, 0},
                5, new int[]{1, 1},
                6, new int[]{1, 2},
                7, new int[]{2, 0},
                8, new int[]{2, 1},
                9, new int[]{2, 2},
                0, new int[]{3, 1}
        );

        StringBuilder sb = new StringBuilder();
        
        for (int number: numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                l = dic.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                r = dic.get(number);
            } else {
                int[] target = dic.get(number);
                int lDist = Math.abs(l[0] - target[0]) + Math.abs(l[1] - target[1]);
                int rDist = Math.abs(r[0] - target[0]) + Math.abs(r[1] - target[1]);
                
                if (lDist < rDist || (lDist == rDist && hand.equals("left"))) {
                    sb.append("L");
                    l = target;
                } else {
                    sb.append("R");
                    r = target;
                }
            }
        }
        
        return sb.toString();
    }
}