package algorithm.소수;

public class 소수_판별 {

    public static void main(String[] args) {
        System.out.println(isPrimeNumber(4));
        System.out.println(isPrimeNumber(7));
    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        }

        // 2부터 n의 제곱근까지 모든 수를 확인하며
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // n이 해당 수로 나누어떨어지면 소수가 아님
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
