import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];

        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }

        int len = num_list.length;
        if(num_list[len - 1] > num_list[len - 2]) {
            answer[answer.length - 1] = num_list[len - 1] - num_list[len - 2];
        } else {
            answer[answer.length - 1] = num_list[len - 1] * 2;
        }
        return answer;  
    }
}