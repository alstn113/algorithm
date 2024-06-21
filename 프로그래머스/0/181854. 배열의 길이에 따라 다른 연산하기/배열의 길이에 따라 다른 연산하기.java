class Solution {
    public int[] solution(int[] arr, int n) {
        for (int i = arr.length % 2 == 0 ? 1 : 0; i<arr.length; i += 2) {
            arr[i] += n;
        }
        return arr;
    }
}