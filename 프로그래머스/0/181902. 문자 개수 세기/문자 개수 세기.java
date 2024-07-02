class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char c : my_string.toCharArray()) {
            if(Character.isUpperCase(c)) {
                answer[c - 'A'] += 1;
                continue;
            }
            answer[c - 'a' + 26] += 1;
        }
        return answer;
    }
}