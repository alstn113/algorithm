class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int d = deliveries.length - 1;
        int p = pickups.length - 1;

        while (d != -1 && deliveries[d] == 0) {
            d -= 1;
        }
        while (p != -1 && pickups[p] == 0) {
            p -= 1;
        }

        long answer = 0;
        while (d != -1 || p != -1) {
            int v = Math.max(d, p) + 1;
            answer += v * 2L;

            d = getLastIndex(cap, deliveries, d);
            p = getLastIndex(cap, pickups, p);
        }

        return answer;
    }

    private int getLastIndex(int cap, int[] datas, int idx) {
        int back = cap;
        while (idx != -1) {
            if (datas[idx] <= back) {
                back -= datas[idx];
                idx -= 1;
            } else {
                datas[idx] -= back;
                break;
            }
        }
        return idx;
    }
}