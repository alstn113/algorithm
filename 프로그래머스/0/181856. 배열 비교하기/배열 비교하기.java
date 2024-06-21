import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) {
            return 1;
        } else if(arr1.length < arr2.length) {
            return -1;
        }
        
        int arr1Sum = Arrays.stream(arr1).sum();
        int arr2Sum = Arrays.stream(arr2).sum();
        
        if(arr1Sum > arr2Sum) {
            return 1;
        } else if (arr1Sum < arr2Sum) {
            return -1;
        }
        return 0;
    }
}