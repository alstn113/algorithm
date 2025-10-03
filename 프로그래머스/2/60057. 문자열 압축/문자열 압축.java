class Solution {
    public int solution(String s) {
        int len = s.length();
        int result = len;
        for (int i = 1; i <= len / 2; i++) {
            int cnt = 0;

            String tmp = s.substring(0, i);
            int sameCnt = 1;

            for (int k = 1; k < len / i; k++) {
                String cur = s.substring(k * i, k * i + i);
                if (tmp.equals(cur)) {
                    sameCnt += 1;
                } else {
                    if (sameCnt > 1) {
                        cnt += String.valueOf(sameCnt).length();
                    }
                    cnt += i;
                    sameCnt = 1;
                    tmp = cur;
                }
            }

            if (sameCnt > 1) {
                cnt += String.valueOf(sameCnt).length();
            }
            cnt += i;

            cnt += len % i;
            result = Math.min(result, cnt);
        }

        return result;
    }
}