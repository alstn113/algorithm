class Solution {
    public int solution(int n, int w, int num) {
        int result = 0;

        while (true) {
            int stage = (int) Math.ceil((double) num / w);
            int next = Math.abs(stage * w - num) * 2 + 1;

            num += next;
            result++;
            
            if (num > n) {
                break;
            }
        }

        return result;
    }
}

