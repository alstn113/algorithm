class Solution {
    public int solution(String s) {
        int answer = 0;
        int past = 0;
        String[] arr = s.split(" ");
        for (String string : arr) {
            if (string.equals("Z")) {
                answer -= past;
            } else {
                int num = Integer.parseInt(string);
                answer += num;
                past = num;
            }
        }
        return answer;
    }
}