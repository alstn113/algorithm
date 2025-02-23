class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int cur = storey % 10;
            storey /= 10;

            if (cur > 5) {
                answer += 10 - cur;
                storey += 1;
            } else if (cur < 5) {
                answer += cur;
            } else {
                int next = storey % 10;
                if (next >= 5) {
                    answer += 10 - cur;
                    storey += 1;
                } else {
                    answer += cur;
                }
            }
        }

        return answer;
    }
}