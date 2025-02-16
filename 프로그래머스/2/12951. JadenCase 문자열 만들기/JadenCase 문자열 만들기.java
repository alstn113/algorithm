class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("");
        
        for (int i = 0; i < words.length; i++) {
            if (i == 0 || words[i - 1].equals(" ")) {
                sb.append(words[i].toUpperCase());
            } else {
                sb.append(words[i].toLowerCase());
            }
        }
        
        return sb.toString();
    }
}