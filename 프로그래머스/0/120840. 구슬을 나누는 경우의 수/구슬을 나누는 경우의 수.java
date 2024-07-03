import java.math.BigInteger;


class Solution {
    public BigInteger solution(int balls, int share) {
        return factorial(balls).divide(factorial(share)).divide(factorial(balls - share));
    }

    public BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}
