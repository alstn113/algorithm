class Solution {
    public int solution(int a, int b) {
        int q = Integer.parseInt(a + "" + b);
        int w = 2*a*b;
        
        return q>w ? q : w;
    }
}