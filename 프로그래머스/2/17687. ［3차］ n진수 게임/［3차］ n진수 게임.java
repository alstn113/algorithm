class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(num, n));
            num += 1;
        }
        String s = sb.toString().toUpperCase();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(s.charAt(m * i + p - 1));
        }

        return result.toString();
    }
}