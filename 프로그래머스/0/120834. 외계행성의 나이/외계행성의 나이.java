class Solution {
    public String solution(int age) {
        String alphabet = "abcdefghij";
        String answer = "";
        
        while (age > 0) {
            answer = alphabet.charAt(age % 10) + answer;
            age /= 10;
        }
        
        return answer;
    }
}