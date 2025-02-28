class Solution {
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        int n = s.length() / 2;
        int v = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            v = Math.min(zip(s, i), v);
        }

        return v;
    }
    public int zip(String s, int n) {
        String rangeStr = s.substring(0, n);
        int cnt = 1;
        int answer = 0;
        for (int i = 1; i < s.length() / n; i++) {
            String cur = s.substring(i * n, (i + 1) * n);
            if (!rangeStr.equals(cur)) {
                if (cnt > 1) {
                    answer += String.valueOf(cnt).length();
                }
                answer += n;
                cnt = 1;
                rangeStr = cur;
                continue;
            }

            cnt += 1;
        }

        if (cnt > 1) {
            answer += String.valueOf(cnt).length();
        }
        answer += n;
        answer += s.length() % n;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("a")); // 7
    }
}