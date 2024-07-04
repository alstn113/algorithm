import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            boolean flag = true;
            int num = i;
            while (num > 0) {
                if (num % 5 != 0) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (flag) {
                result.add(i);
            }
        }
        return result.isEmpty() ? new int[]{-1} : result.stream().mapToInt(v -> v).toArray();
    }
}
