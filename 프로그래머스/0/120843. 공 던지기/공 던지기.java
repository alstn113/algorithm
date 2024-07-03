class Solution {
    public int solution(int[] numbers, int k) {
        return (k-1)*2 % numbers.length+1;
    }
}