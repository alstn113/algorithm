class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i = 0; i<my_strings.length; i++) {
            int[] part = parts[i];
            answer += my_strings[i].substring(part[0], part[1] + 1);
        }
        return answer;
    }
}