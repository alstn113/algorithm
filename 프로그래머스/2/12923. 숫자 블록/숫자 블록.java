class Solution {
    public int[] solution(long begin, long end) {
        int[] answers = new int[(int) (end - begin + 1)];
        for (long i = 0; i < end - begin + 1; i++) {
            long n = begin + i;
            if (n == 1) {
                answers[(int) i] = 0;
                continue;
            }

            answers[(int) i] = getNum(n);
        }

        return answers;
    }

    public int getNum(long n) {
        int maxDivisor = 1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                long pairDivisor = n / i;

                // 10,000,000 이하인 약수 중 가장 큰 값 저장
                if (pairDivisor <= 10_000_000) {
                    return (int) pairDivisor;
                }

                if (i <= 10_000_000) {
                    maxDivisor = (int) i;
                }
            }
        }
        return maxDivisor;
    }
}