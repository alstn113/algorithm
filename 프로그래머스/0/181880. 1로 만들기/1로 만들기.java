class Solution {
    public int solution(int[] num_list) {
        int result = 0;
        for (int num : num_list) {
            int cnt = 0;
            while(num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num -= 1;
                    num /= 2;
                }
                
                cnt += 1;
            }
            result += cnt;
        }
        return result;
    }
}