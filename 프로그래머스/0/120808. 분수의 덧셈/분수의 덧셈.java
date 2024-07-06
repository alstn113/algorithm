class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bj = numer1 * denom2 + numer2 * denom1;
        int bm = denom1 * denom2;

        return new int[]{bj / gcd(bj, bm), bm / gcd(bj, bm)};
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return a > b ? gcd(b, a % b) : gcd(a, b % a);
    }
}