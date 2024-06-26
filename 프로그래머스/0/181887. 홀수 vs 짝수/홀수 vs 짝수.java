class Solution {
    public int solution(int[] num_list) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i<num_list.length; i+=2) {
            evenSum += num_list[i];
        }
        for (int i = 1; i<num_list.length; i+=2) {
            oddSum += num_list[i];
        }
        return Math.max(evenSum, oddSum);
    }
}