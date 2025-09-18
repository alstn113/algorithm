class Solution {
    public int solution(String s) {
        int result = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int total = 0;
            String first = s.substring(0, i);
            int cnt = 1;
            for (int k = 1; k < s.length() / i; k++) {
                String next = s.substring(k * i, k * i + i);
                if (first.equals(next)) {
                    cnt += 1;
                } else {
                    total += i;
                    if (cnt > 1) {
                        total += String.valueOf(cnt).length();
                    }

                    first = next;
                    cnt = 1;
                }
            }

            total += i;
            if (cnt > 1) {
                total += String.valueOf(cnt).length();
            }

            total += s.length() % i;

            result = Math.min(result, total);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ababcdcdababcdcd"));
    }
}
