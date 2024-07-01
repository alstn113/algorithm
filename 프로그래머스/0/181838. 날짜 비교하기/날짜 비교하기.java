class Solution {
    public int solution(int[] date1, int[] date2) {
        int date1Num = date1[0] * 365 + date1[1] * 30 + date1[2];
        int date2Num = date2[0] * 365 + date2[1] * 30 + date2[2];
        
        return date1Num >= date2Num ? 0 : 1;
    }
}