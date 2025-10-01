import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        
        long leftSum = 0;
        long rightSum = 0;
        
        for (int i = 0; i < n; i++) {
            leftSum += queue1[i];
            rightSum += queue2[i];
        }
        
        long total = leftSum + rightSum;
        if (total % 2 != 0) {
            return -1;
        }
        long target = total / 2;
        
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
        }
        
        int left = 0; 
        int right = n;  
        int moves = 0;
        int maxMoves = 4 * n; 
        
        while (moves <= maxMoves && left < arr.length && right < arr.length) {
            if (leftSum == target) {
                return moves;
            }
            
            if (leftSum < target) {
                leftSum += arr[right];
                right++;
            } else {
                leftSum -= arr[left];
                left++;
            }
            moves++;
        }
        
        return -1;
    }
}
