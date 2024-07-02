import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int cnt = 0;
        while (true) {
            int[] newArr = Arrays.copyOf(arr, arr.length);
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    newArr[i] = newArr[i] / 2;
                    flag = true;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    newArr[i] = arr[i] * 2 + 1;
                    flag = true;
                }
            }
            if (!flag) {
                return cnt;
            }

            arr = newArr;
            cnt += 1;
        }
    }
}