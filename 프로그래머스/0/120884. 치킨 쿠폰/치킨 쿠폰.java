class Solution {
    public int solution(int chicken) {
        int result = 0;
        while (chicken >= 10) {
            int order = chicken / 10;
            int coupon = chicken % 10;
            result += order;
            chicken = order + coupon;
        }
        return result;
    }
}