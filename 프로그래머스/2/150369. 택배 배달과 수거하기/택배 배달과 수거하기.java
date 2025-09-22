class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int a = n - 1;
        int b = n - 1;

        while (true) {
            // 최소 찾기
            while (a > -1 && deliveries[a] == 0) {
                a -= 1;
            }

            while (b > -1 && pickups[b] == 0) {
                b -= 1;
            }

            if (a == -1 && b == -1) {
                return answer;
            }

            answer += (Math.max(a, b) + 1) * 2L;

            // 줄이기
            int av = cap;
            int bv = cap;

            while (a > -1 && av > 0) {
                if (deliveries[a] >= av) {
                    deliveries[a] -= av;
                    av = 0;
                } else {
                    av -= deliveries[a];
                    deliveries[a] = 0;
                    a -= 1;
                }
            }

            while (b > -1 && bv > 0) {
                if (pickups[b] >= bv) {
                    pickups[b] -= bv;
                    bv = 0;
                } else {
                    bv -= pickups[b];
                    pickups[b] = 0;
                    b -= 1;
                }
            }
        }
    }
}
