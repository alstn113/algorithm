class Solution {
    public String solution(String new_id) {
        // 1
        String s = new_id.toLowerCase();
        
        // 2
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        s = sb.toString();
        
        // 3
        while(s.contains("..")) {
            s = s.replace("..", ".");
        }
        
        // 4
        if (s.startsWith(".")) {
            s = s.substring(1);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length()-1);
        }
        
        // 5
        if (s.isBlank()) {
            s = "a";
        }
        
        // 6
        if (s.length() >= 16) {
            s = s.substring(0, 15);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length()-1);
        }
        
        // 7
        while(s.length() <= 2) {
            char c = s.charAt(s.length() - 1);
            s += c;
        }
        
        return s;
    }
}