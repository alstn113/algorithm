class Solution {
    public int solution(int n) {
        int result = 0;
        for (String s : String.valueOf(n).split("")) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}