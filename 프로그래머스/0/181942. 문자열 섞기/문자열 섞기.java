class Solution {
    public String solution(String str1, String str2) {
        String result = "";
        for (int i=0; i<str1.length(); i++) {
            result += str1.charAt(i);
            result += str2.charAt(i);            
        }
        return result;
    }
}