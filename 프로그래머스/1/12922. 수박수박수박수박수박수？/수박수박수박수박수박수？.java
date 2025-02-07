class Solution {
    public String solution(int n) {
        String s = "수박";
        
        if(n % 2 == 1) {
            return s.repeat(n / 2) + "수";
        }
        
        return s.repeat(n / 2);
    }
}