import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < answer.length; i++) {
            int idx = 1;
            for (int j = 0; j < answer.length; j++) {
                if (emergency[i] < emergency[j]) {
                    idx++;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }
}