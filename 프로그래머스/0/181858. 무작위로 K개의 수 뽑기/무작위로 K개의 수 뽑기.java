import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        k -= 1;
        for (int i = 1; i < arr.length; i++) {
            if (k == 0) {
                break;
            }

            if (!answer.contains(arr[i])) {
                answer.add(arr[i]);
                k -= 1;
            }
        }
        
        for (int i = 0; i < k; i++) {
            answer.add(-1);
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}