class Solution {
    public int solution(int a, int b) {
        int q = Integer.parseInt(a + "" + b);
        int w = Integer.parseInt(b + "" + a);
        return q > w ? q : w;
    }
}