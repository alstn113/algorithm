class Solution {
    public int solution(int a, int b, int n) {
       int result = 0;

        while (n >= a) {
            int v = b * (n / a);
            result += v;
            n = v + (n % a);
        }

        return result;
    }
}