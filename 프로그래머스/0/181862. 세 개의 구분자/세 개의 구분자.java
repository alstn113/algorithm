import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] strArr = myStr.replace("a", " ").replace("b", " ").replace("c", " ").split(" ");
        String[] arr = Arrays.stream(strArr).filter(s -> !s.isEmpty()).toArray(String[]::new);
        if(arr.length == 0) {
            return new String[] { "EMPTY" };
        }
        return arr;
    }
}