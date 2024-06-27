class Solution {
    public int solution(String number) {
        int result = 0;
        
        for (String s : number.split("")) {
            result += Integer.parseInt(s);
        }
        
        return result%9;
    }
}