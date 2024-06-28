import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        return Arrays.stream(arr).filter(v -> !v.isEmpty()).sorted().toArray(String[]::new);
    }
}