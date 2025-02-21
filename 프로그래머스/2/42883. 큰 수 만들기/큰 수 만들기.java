import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        int[] intArr = Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .mapToInt(v -> v).toArray();

        int cnt = 0;
        Stack<Integer> st = new Stack<>();

        for (int v : intArr) {
            while (!st.isEmpty() && st.peek() < v && cnt < k) {
                st.pop();
                cnt += 1;
            }
            st.push(v);
        }

        while (cnt < k) {
            st.pop();
            cnt += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : st) {
            sb.append(integer);
        }
        return sb.toString();
    }
}