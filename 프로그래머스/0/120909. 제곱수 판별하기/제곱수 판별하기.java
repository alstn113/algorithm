class Solution {
    public int solution(int n) {
        int a = (int) Math.sqrt(n);
        return a*a == n ? 1 : 2;
    }
}