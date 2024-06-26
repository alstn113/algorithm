import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).map(v -> v.length()).mapToInt(v -> v).toArray();
    }
}