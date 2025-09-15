class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() <= t * m) {
            sb.append(Integer.toString(i, n));
            i += 1;
        }

        StringBuilder sb1 = new StringBuilder();
        for (int k = p - 1; k < t * m; k += m) {
            sb1.append(sb.charAt(k));
        }
        return sb1.toString().toUpperCase();
    }
}