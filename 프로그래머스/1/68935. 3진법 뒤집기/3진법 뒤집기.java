class Solution {
    public int solution(int n) {
        String s = "";
        
        while (n > 0) {
            s = (n % 3) + s;
            n /= 3;
        }

        s = new StringBuilder(s).reverse().toString();
        
        return Integer.parseInt(s, 3);
    }
}