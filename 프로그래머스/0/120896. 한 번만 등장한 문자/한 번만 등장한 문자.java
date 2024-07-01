class Solution {
    public String solution(String s) {
        char[] charArr = new char[26];
        for (char c : s.toCharArray()) {
            charArr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 1) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}