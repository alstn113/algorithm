import java.util.Arrays;

class Solution {

    static int zeroCount = 0;
    static int transformCount = 0;

    public int[] solution(String s) {
        String current = s;

        while (!current.equals("1")) {
            Integer[] bin = Arrays.stream(current.split(""))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            int oneCount = 0;
            for (Integer digit : bin) {
                if (digit == 1) {
                    oneCount++;
                }
            }
            zeroCount += bin.length - oneCount;
            

            current = Integer.toBinaryString(oneCount);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}
