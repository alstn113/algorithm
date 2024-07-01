import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] emergency) {
        List<Integer> sorted = Arrays.stream(emergency)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int[] result = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            result[i] = sorted.indexOf(emergency[i]) + 1;
        }

        return result;
    }
}