import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        String[] split = numbers.split("");
        int length = split.length;

        for (int i = 1; i <= length; i++) {
            visited = new boolean[length];
            generatePermutations(split, "", i);
        }

        return primes.size();
    }

    public void generatePermutations(String[] nums, String current, int limit) {
        if (current.length() == limit) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primes.add(num);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(nums, current + nums[i], limit);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
