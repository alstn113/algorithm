import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        String[] arr = str.split("");
        for (String s : arr) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}