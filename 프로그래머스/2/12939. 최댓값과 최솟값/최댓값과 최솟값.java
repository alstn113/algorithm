import java.util.*;

class Solution {
    public String solution(String s) {
        Integer[] result = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        return result[0] + " " + result[result.length-1];
    }
}