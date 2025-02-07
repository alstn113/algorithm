import java.util.*;

class Solution {
    public String solution(String s) {
        List<String> strList = Arrays.asList(s.split(""));
        strList.sort(Comparator.reverseOrder());
        return String.join("", strList);
    }
}