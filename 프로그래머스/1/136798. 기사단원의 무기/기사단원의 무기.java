class Solution {
    public int solution(int number, int limit, int power) {
        int totalWeight = 0; 

        for (int i = 1; i <= number; i++) {
            int attackPower = countDivisors(i);

            if (attackPower > limit) {
                totalWeight += power;
            } else {
                totalWeight += attackPower;
            }
        }

        return totalWeight; 
    }

    public int countDivisors(int n) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count += 1; 
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }
}
