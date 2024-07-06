class Solution {
    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
            sum += i;
        }
        int c = (total - sum)/num;
        for (int i=0; i<arr.length; i++) {
            arr[i] += c;
        }
        return arr;
    }
}