class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                p += 1;
            } else if (c == 'y' || c == 'Y') {
                y += 1;
            }
        }
        
        return p == y;
    }
}