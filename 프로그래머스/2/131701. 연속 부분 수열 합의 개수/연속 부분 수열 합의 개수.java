import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int size = elements.length + elements.length;

        int[] arr = new int[size];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j=0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}