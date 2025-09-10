class Solution {
    public long solution(int r1, int r2) {
        long rr1 = (long) r1 * r1;
        long rr2 = (long) r2 * r2;

        long result = 0;
        for (int i = r2; i > 0; i--) {
            long ii2 = (long) i * i;
            double v2 = Math.sqrt(rr2 - ii2);
            double v1 = Math.sqrt(rr1 - ii2);

            result += (long) v2 - (long) Math.ceil(v1) + 1;
        }

        return result * 4;
    }
}