import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] result = myString.split("x", -1);
        return Arrays.stream(result).mapToInt(v -> v.length()).toArray();
    }
}