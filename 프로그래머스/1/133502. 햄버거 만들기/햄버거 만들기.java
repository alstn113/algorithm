class Solution {
    public int solution(int[] ingredients) {
        int[] st = new int[ingredients.length];
        int idx = 0;
        int answer = 0;

        for (int ingredient : ingredients) {
            st[idx] = ingredient;
            idx += 1;

            if (idx >= 4) {
                if (st[idx - 1] == 1 && st[idx - 2] == 3 && st[idx - 3] == 2 && st[idx - 4] == 1) {
                    answer += 1;
                    idx -= 4;
                }
            }
        }

        return answer;
    }
}