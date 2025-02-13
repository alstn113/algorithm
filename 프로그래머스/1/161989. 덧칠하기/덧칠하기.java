class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 1;
        int start = section[0];
        for (int i=0; i<section.length; i++) {
            if (section[i] - start + 1 > m) {
                result += 1;
                start = section[i];
            }
        }
        return result;
    }
}