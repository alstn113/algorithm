class Solution {
    public String solution(String p) {
        if (p.isBlank()) {
            return "";
        }
        
        int left=0;
        int right=0;
        boolean isCorrect = true;
        
        int t = 0;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }
            
            if (left < right) {
                isCorrect = false;
            }
            
            if (left == right) {
                t = i;
                break;
            }
        }
        String u = p.substring(0, t+1);
        String v = p.substring(t+1);
        
        if (isCorrect) {
            String newStr =  u + solution(v);
            return newStr;
        }
        
        u = u.substring(1, u.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        
        String newStr =  "(" + solution(v) + ")" + sb.toString();
        return newStr;
    }
}