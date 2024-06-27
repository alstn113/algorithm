class Solution {
    public int[] solution(int[] num_list) {
        int even = 0;
        int odd = 0;
        for (int n : num_list) {
            if(n % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        return new int[] {even, odd};
    }
}