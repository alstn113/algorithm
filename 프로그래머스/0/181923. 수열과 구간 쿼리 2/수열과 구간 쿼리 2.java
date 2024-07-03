import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < queries.length; j++) {
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];

            int[] newArr = Arrays.copyOfRange(arr, s, e + 1);
            Arrays.sort(newArr);

            boolean flag = false;
            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] > k) {
                    result.add(newArr[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(-1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}