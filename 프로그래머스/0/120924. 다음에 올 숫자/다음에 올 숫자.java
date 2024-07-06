class Solution {
    public int solution(int[] common) {
        int a = common[0], b = common[1], c = common[2];
        if (a+c == 2*b) {
            return common[common.length-1] + b-a;
        }
        return common[common.length-1]*(b/a);
    }
}