class Solution {
    public int solution(int[] numbers) {
        int result = 45;
        for (int n : numbers) {
            result -= n;
        }
        return result;
    }
}