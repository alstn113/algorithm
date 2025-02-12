class Solution {
    public int solution(int[][] sizes) {
        int s1=0;
        int s2=0;
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                s1 = Math.max(size[0], s1);
                s2 = Math.max(size[1], s2);
            } else {
                s1 = Math.max(size[1], s1);
                s2 = Math.max(size[0], s2);
            }
        }
        
        return s1 * s2;
    }
}