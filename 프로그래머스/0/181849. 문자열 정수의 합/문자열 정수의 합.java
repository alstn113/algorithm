class Solution {
    public int solution(String num_str) {
        int result = 0;
        for (String s : num_str.split("")) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}