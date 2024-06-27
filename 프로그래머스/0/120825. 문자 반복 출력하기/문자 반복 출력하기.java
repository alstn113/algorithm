class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (String s : my_string.split("")) {
            sb.append(s.repeat(n));
        }
        return sb.toString();
    }
}