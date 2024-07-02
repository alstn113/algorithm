class Solution {
    public int solution(String[] strArr) {
        int[] arr = new int[31];
        for (String s: strArr) {
            arr[s.length()]++;
        }
        int max = arr[1];
        for (int i = 2; i < 31; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}