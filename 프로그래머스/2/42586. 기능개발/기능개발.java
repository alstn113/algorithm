import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        for (int i=0; i<progresses.length; i++) {
            arr[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }
        List<Integer> result = new ArrayList<>();
        int v = arr[0];
        int sum = 1;

        for (int i=1; i<arr.length; i++) {
            if (v >= arr[i]) {
                sum += 1;
            } else {
                result.add(sum);
                v = arr[i];
                sum = 1;
            }
        }

        result.add(sum);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
