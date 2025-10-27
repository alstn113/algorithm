package algorithm.최대공약수_최소공배수;

public class 최대공약수_최소공배수 {

    static final int N = 3;
    static final int M = 12;

    public static void main(String[] args) {
        int gcd = gcd(N, M);
        int lcm = lcm(N, M);

        System.out.println("최대공약수: " + gcd);
        System.out.println("최소공배수: " + lcm);
    }

    // 최대공약수 (Greatest Common Divisor)
    public static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        if (n > m) {
            return gcd(m, n % m);
        }
        return gcd(n, m % n);
    }

    // 최소공배수 (Least Common Multiple)
    public static int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}
