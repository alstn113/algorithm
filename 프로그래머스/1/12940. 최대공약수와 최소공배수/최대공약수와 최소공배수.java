class Solution {
    public int[] solution(int n, int m) {
        int a = gcd(n, m);
        int b = lcm(n, m);
        
        return new int[] {a, b};
    }
    
    public int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        if (n > m) {
            return gcd(m, n % m);
        }
        return gcd(n, m % n);
    }

    public int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}