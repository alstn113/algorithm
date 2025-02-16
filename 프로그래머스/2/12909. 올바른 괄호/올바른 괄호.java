class Solution {
    boolean solution(String s) {
        int left = 0;
        int right = 0;
        
        String[] split = s.split("");
        for (String v : split) {
            if(v.equals("(")) {
                left += 1;
            } else {
                right += 1;
            }
            
            if (left < right) return false;
        }
        
        if (left != right) return false;
        
        return true;
    }
}