class Solution {
    public int solution(int[] arr) {
        int result = arr[0];
        for (int i=1; i<arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public int lcm(int n, int m) {
        if (m == 0) {
            return n;
        }
        if (n > m) {
            return lcm(m, n%m);
        }
        return lcm(n, m%n);
    }

    public int gcd(int n, int m) {
        return (n * m) / lcm(n, m);
    }
}