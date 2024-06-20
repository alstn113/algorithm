class Solution {
    public String solution(String cipher, int code) {
        String result = "";
        for (int i=code; i<=cipher.length(); i += code) {
            result += cipher.charAt(i-1);
        }
        return result;
    }
}