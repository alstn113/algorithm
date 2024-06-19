class Solution {
    public int solution(String my_string) {
        char[] charArray = my_string.toCharArray();
        int result = 0;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                result += c - '0';
            }
        }
        return result;
    }
}